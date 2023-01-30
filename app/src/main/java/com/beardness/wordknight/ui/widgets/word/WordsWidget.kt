package com.beardness.wordknight.ui.widgets.word

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WordsWidget(
    modifier: Modifier,
    words: List<String>,
    copyToClipboard: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(words) { word ->
            WordElementWidget(
                title = word,
                onClickCopy = { copyToClipboard(word) },
            )
        }
    }
}