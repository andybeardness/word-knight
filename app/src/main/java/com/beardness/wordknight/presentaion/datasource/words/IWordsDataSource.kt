package com.beardness.wordknight.presentaion.datasource.words

import com.beardness.wordknight.data.wordstype.WordsType

interface IWordsDataSource {
    suspend fun words(type: WordsType): List<String>
}