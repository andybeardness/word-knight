package com.beardness.wordknight.utils.wordsmatcher

import javax.inject.Inject

class WordsMatcher @Inject constructor() {

    fun filter(word: String, pattern: String): Boolean {
        val lengthIsNotAvailable =
            !isLengthEqualsOrMore(
                word = word,
                pattern = pattern,
            )

        if (lengthIsNotAvailable) {
            return false
        }

        pattern.zip(word).forEach { (patternChar, wordChar) ->
            val isCharNotEquals =
                !isCharEquals(
                    wordChar = wordChar,
                    patternChar = patternChar,
                )

            if (isCharNotEquals) {
                return false
            }
        }

        return true
    }

    private fun isLengthEqualsOrMore(word: String, pattern: String): Boolean {
        val wordLength = word.length
        val patternLength = pattern.length

        return wordLength >= patternLength
    }

    private fun isCharEquals(wordChar: Char, patternChar: Char): Boolean =
        patternChar == wordChar
                || patternChar == '_'

}