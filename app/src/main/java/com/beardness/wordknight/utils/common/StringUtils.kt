package com.beardness.wordknight.utils.common

fun String.httpsLinkPretty(): String =
    this.replace(oldValue = "https://", newValue = "")