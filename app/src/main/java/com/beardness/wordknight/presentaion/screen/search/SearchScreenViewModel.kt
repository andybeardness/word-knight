package com.beardness.wordknight.presentaion.screen.search

import androidx.lifecycle.ViewModel
import com.beardness.wordknight.di.modules.qualifiers.IoCoroutineScope
import com.beardness.wordknight.di.modules.qualifiers.MainCoroutineScope
import com.beardness.wordknight.presentaion.usecases.WordsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val wordsUseCases: WordsUseCases,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
    @MainCoroutineScope private val mainCoroutineScope: CoroutineScope,
): ViewModel() {

    private val _words = MutableStateFlow(value = emptyList<String>())
    val words = _words.asStateFlow()

    fun filter(pattern: String) {
        ioCoroutineScope.launch() {
            val filteredWords = wordsUseCases.filter(pattern = pattern)

            mainCoroutineScope.launch {
                _words.emit(value = filteredWords)

            }
        }
    }

    fun clear() {
        mainCoroutineScope.launch {
            _words.emit(value = emptyList())
        }
    }
}