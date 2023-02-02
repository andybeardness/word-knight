package com.beardness.wordknight.presentaion.usecases.words

import com.beardness.wordknight.data.wordstype.WordsType
import com.beardness.wordknight.data.wordstype.next
import com.beardness.wordknight.presentaion.repo.words.IWordsRepo
import com.beardness.wordknight.utils.wordsmatcher.IWordsMatcher
import javax.inject.Inject

class WordsUseCases @Inject constructor(
    private val wordsRepo: IWordsRepo,
    private val wordsMatcher: IWordsMatcher,
) : IWordsUseCases {
    private val words = wordsRepo.words
    override val wordsType = wordsRepo.wordsType

    override suspend fun setup(wordsType: WordsType) {
        wordsRepo.setupWords(wordsType = wordsType)
    }

    override suspend fun filter(pattern: String): List<String> {
        return words
            .value
            .filter { word -> wordsMatcher.filter(word = word, pattern = pattern) }
            .sortedBy { word -> word.length }
    }

    override suspend fun changeWordsType() {
        val new =
            wordsType
                .value
                ?.next
                ?: WordsType.EN

        wordsRepo.setupWords(wordsType = new)
    }
}