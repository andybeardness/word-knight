package com.beardness.wordknight.presentaion.screen.search

import androidx.lifecycle.ViewModel
import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.di.modules.qualifiers.IoCoroutineScope
import com.beardness.wordknight.di.modules.qualifiers.MainCoroutineScope
import com.beardness.wordknight.presentaion.usecases.device.DeviceUseCases
import com.beardness.wordknight.presentaion.usecases.words.WordsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val wordsUseCases: WordsUseCases,
    private val deviceUseCases: DeviceUseCases,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
    @MainCoroutineScope private val mainCoroutineScope: CoroutineScope,
): ViewModel(), ISearchScreenViewModel {

    private val _words = MutableStateFlow(value = emptyList<String>())
    override val words = _words.asStateFlow()

    private val _wordsType = MutableStateFlow<WordsType?>(value = null)
    override val wordsType = _wordsType.asStateFlow()

    private val _wordsLoading = MutableStateFlow<Boolean>(value = false)
    override val wordsLoading = _wordsLoading.asStateFlow()

    private val _toolbarWordsTypeLoading = MutableStateFlow<Boolean>(value = false)
    override val toolbarWordsTypeLoading = _toolbarWordsTypeLoading.asStateFlow()

    private val _patternLength = MutableStateFlow<Int>(value = 0)
    override val patternLength = _patternLength.asStateFlow()

    init {
        collectWordsType()
    }

    override fun filter(pattern: String) {
        ioCoroutineScope.launch {
            _wordsLoading.emit(value = true)

            _patternLength.emit(value = pattern.length)

            val filteredWords =
                wordsUseCases
                    .filter(
                        pattern = pattern.lowercase(),
                    )

            mainCoroutineScope.launch {
                _words.emit(value = filteredWords)
            }

            _wordsLoading.emit(value = false)
        }
    }

    override fun changeWordsType() {
        ioCoroutineScope.launch {
            mainCoroutineScope.launch {
                _toolbarWordsTypeLoading.emit(value = true)
            }

            wordsUseCases.changeWordsType()

            mainCoroutineScope.launch {
                _toolbarWordsTypeLoading.emit(value = false)
            }
        }
    }

    override fun reset() {
        mainCoroutineScope.launch {
            _words.emit(value = emptyList())
        }
    }

    override fun copyToClipboard(value: String) {
        ioCoroutineScope.launch {
            deviceUseCases.copyToClipboard(value = value)
        }
    }

    private fun collectWordsType() {
        ioCoroutineScope.launch {
            wordsUseCases.wordsType.collect { type ->
                _wordsType.emit(value = type)
            }
        }
    }
}