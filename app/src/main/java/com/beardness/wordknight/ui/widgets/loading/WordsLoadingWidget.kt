package com.beardness.wordknight.ui.widgets.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.wordknight.ui.widgets.word.WordsWidget

@Composable
fun WordsLoadingWidget(
    modifier: Modifier,
    isWordsLoading: Boolean,
    patternLength: Int,
    words: List<String>,
    copyToClipboard: (String) -> Unit,
) {
    if (isWordsLoading) {
        LoadingWidget(
            modifier = modifier
        )
    } else {
        WordsWidget(
            modifier = modifier,
            patternLength = patternLength,
            words = words,
            copyToClipboard = copyToClipboard,
        )
    }
}