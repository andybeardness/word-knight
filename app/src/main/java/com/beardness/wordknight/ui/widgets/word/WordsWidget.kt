package com.beardness.wordknight.ui.widgets.word

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun WordsWidget(
    modifier: Modifier,
    patternLength: Int,
    words: List<String>,
    copyToClipboard: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(words) { word ->
            val copyButtonColor =
                if (word.length == patternLength) {
                    WordKnightTheme.colors.green
                } else {
                    WordKnightTheme.colors.blue
                }

            WordElementWidget(
                title = word,
                onClickCopy = { copyToClipboard(word) },
                copyButtonColor = copyButtonColor,
            )
        }
    }
}