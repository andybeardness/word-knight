package com.beardness.wordknight.utils.wordsmatcher

interface IWordsMatcher {
    fun filter(word: String, pattern: String): Boolean
}