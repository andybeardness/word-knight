package com.beardness.wordknight.utils.searchfilter

import javax.inject.Inject

class SearchInputManager @Inject constructor() : ISearchInputManager {
    override fun prepare(input: String): String =
        input.map { char -> char.toPreparedSymbol() }
            .joinToString(separator = "")

    private fun Char.toPreparedSymbol(): Char =
        if (this.isLetter()) {
            this
        } else {
            '_'
        }
}