package com.beardness.wordknight.presentaion.repo

import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.presentaion.datasource.WordsDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WordsRepo(
    private val wordsDataSource: WordsDataSource,
) {
    private val _words = MutableStateFlow(value = emptyList<String>())
    val words = _words.asStateFlow()

    suspend fun setupWords(wordsType: WordsType) {
        val words = wordsDataSource.words(type = wordsType)

        _words.emit(value = words)
    }
}