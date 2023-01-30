package com.beardness.wordknight.ui.widgets.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun SearchButtonComponent(
    onClickSearch: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable {
                onClickSearch()
            }
            .fillMaxHeight()
            .width(width = 64.dp),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = "",
            tint = WordKnightTheme.colors.blue,
        )
    }
}