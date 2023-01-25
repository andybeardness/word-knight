package com.beardness.wordknight.data.wordstype

enum class WordsType(val filename: String) {
    RU(filename = "ru_words.txt"),
    EN(filename = "en_words.txt"),
}

fun String.localeToWordsType(): WordsType =
    when (this) {
        "EN" -> WordsType.EN
        "RU" -> WordsType.RU
        else -> WordsType.EN
    }