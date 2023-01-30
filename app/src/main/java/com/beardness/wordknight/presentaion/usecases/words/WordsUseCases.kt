package com.beardness.wordknight.presentaion.usecases.words

import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.data.wordstype.next
import com.beardness.wordknight.presentaion.repo.words.WordsRepo
import com.beardness.wordknight.utils.wordsmatcher.WordsMatcher
import javax.inject.Inject

class WordsUseCases @Inject constructor(
    private val wordsRepo: WordsRepo,
    private val wordsMatcher: WordsMatcher,
) {
    private val words = wordsRepo.words

    val wordsType = wordsRepo.wordsType

    suspend fun setup(wordsType: WordsType) {
        wordsRepo.setupWords(wordsType = wordsType)
    }

    suspend fun filter(pattern: String): List<String> {
        return words
            .value
            .filter { word -> wordsMatcher.filter(word = word, pattern = pattern) }
    }

    suspend fun changeWordsType() {
        val new =
            wordsType
                .value
                ?.next
                ?: WordsType.EN

        wordsRepo.setupWords(wordsType = new)
    }
}