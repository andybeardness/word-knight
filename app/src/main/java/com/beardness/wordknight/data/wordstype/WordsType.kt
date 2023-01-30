package com.beardness.wordknight.data.wordstype

enum class WordsType(
    val fileName: String,
) {
    RU(
        fileName = "ru_words.txt",
    ),

    EN(
        fileName = "en_words.txt",
    ),
}

fun String.localeToWordsType(): WordsType =
    when (this) {
        "EN" -> WordsType.EN
        "RU" -> WordsType.RU
        else -> WordsType.EN
    }

val WordsType?.shortName: String
    get() =
        when (this) {
            WordsType.EN -> "EN"
            WordsType.RU -> "RU"
            null -> "--"
        }

val WordsType.next: WordsType
    get() =
        when (this) {
            WordsType.EN -> WordsType.RU
            WordsType.RU -> WordsType.EN
        }