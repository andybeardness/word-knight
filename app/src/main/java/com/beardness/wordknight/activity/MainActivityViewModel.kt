package com.beardness.wordknight.activity

import androidx.lifecycle.ViewModel
import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.di.modules.qualifiers.IoCoroutineScope
import com.beardness.wordknight.presentaion.usecases.device.DeviceUseCases
import com.beardness.wordknight.presentaion.usecases.words.WordsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val wordsUseCases: WordsUseCases,
    private val deviceUseCases: DeviceUseCases,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel() {

    val copyToClipboard = deviceUseCases.copyToClipboard

    fun setupWords(wordsType: WordsType) {
        ioCoroutineScope.launch {
            wordsUseCases.setup(wordsType = wordsType)
        }
    }
}