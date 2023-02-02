package com.beardness.wordknight.presentaion.repo.words

import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.presentaion.datasource.words.IWordsDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WordsRepo(
    private val wordsDataSource: IWordsDataSource,
) : IWordsRepo {
    private val _words = MutableStateFlow(value = emptyList<String>())
    override val words = _words.asStateFlow()

    private val _wordsType = MutableStateFlow<WordsType?>(value = null)
    override val wordsType = _wordsType.asStateFlow()

    override suspend fun setupWords(wordsType: WordsType) {
        val words = wordsDataSource.words(type = wordsType)

        _words.emit(value = words)
        _wordsType.emit(value = wordsType)
    }
}