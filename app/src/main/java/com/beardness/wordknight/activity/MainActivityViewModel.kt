package com.beardness.wordknight.activity

import androidx.lifecycle.ViewModel
import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.di.modules.qualifiers.IoCoroutineScope
import com.beardness.wordknight.presentaion.usecases.WordsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val wordsUseCases: WordsUseCases,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel() {

    fun setupWords(wordsType: WordsType) {
        ioCoroutineScope.launch {
            wordsUseCases.setup(wordsType = wordsType)
        }
    }
}