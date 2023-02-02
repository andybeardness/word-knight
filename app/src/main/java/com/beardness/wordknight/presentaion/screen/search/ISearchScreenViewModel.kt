package com.beardness.wordknight.presentaion.screen.search

import com.beardness.wordknight.data.wordstype.WordsType
import kotlinx.coroutines.flow.StateFlow

interface ISearchScreenViewModel {
    val words: StateFlow<List<String>>
    val wordsType: StateFlow<WordsType?>
    val wordsLoading: StateFlow<Boolean>
    val toolbarWordsTypeLoading: StateFlow<Boolean>
    val patternLength: StateFlow<Int>

    fun filter(pattern: String)
    fun changeWordsType()
    fun reset()
    fun copyToClipboard(value: String)
}