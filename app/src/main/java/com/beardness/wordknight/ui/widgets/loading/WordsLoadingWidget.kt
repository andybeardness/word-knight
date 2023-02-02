package com.beardness.wordknight.ui.widgets.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.wordknight.ui.widgets.word.WordsWidget

@Composable
fun WordsLoadingWidget(
    isWordsLoading: Boolean,
    modifier: Modifier,
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
            words = words,
            copyToClipboard = copyToClipboard,
        )
    }
}