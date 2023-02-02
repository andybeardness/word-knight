package com.beardness.wordknight.presentaion.repo.words

import com.beardness.wordknight.data.wordstype.WordsType
import kotlinx.coroutines.flow.StateFlow

interface IWordsRepo {
    val words: StateFlow<List<String>>
    val wordsType: StateFlow<WordsType?>

    suspend fun setupWords(wordsType: WordsType)
}