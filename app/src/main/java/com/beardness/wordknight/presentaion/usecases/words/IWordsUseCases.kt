package com.beardness.wordknight.presentaion.usecases.words

import com.beardness.wordknight.data.wordstype.WordsType
import kotlinx.coroutines.flow.StateFlow

interface IWordsUseCases {
    val wordsType: StateFlow<WordsType?>

    suspend fun setup(wordsType: WordsType)
    suspend fun filter(pattern: String): List<String>
    suspend fun changeWordsType()
}