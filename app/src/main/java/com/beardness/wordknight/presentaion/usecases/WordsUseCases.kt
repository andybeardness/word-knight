package com.beardness.wordknight.presentaion.usecases

import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.presentaion.repo.WordsRepo
import com.beardness.wordknight.utils.wordsmatcher.WordsMatcher
import javax.inject.Inject

class WordsUseCases @Inject constructor(
    private val wordsRepo: WordsRepo,
    private val wordsMatcher: WordsMatcher,
) {
    private val words = wordsRepo.words

    suspend fun setup(wordsType: WordsType) {
        wordsRepo.setupWords(wordsType = wordsType)
    }

    suspend fun filter(pattern: String): List<String> {
        return words
            .value
            .filter { word -> wordsMatcher.filter(word = word, pattern = pattern) }
    }

}