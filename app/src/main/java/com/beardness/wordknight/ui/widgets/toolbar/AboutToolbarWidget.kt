package com.beardness.wordknight.ui.widgets.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beardness.wordknight.ui.theme.WordKnightTheme
import com.beardness.wordknight.ui.widgets.toolbar.components.ToolbarTitleComponent

@Composable
fun AboutToolbarWidget(
    title: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 64.dp)
            .background(color = WordKnightTheme.colors.card)
    ) {

        ToolbarTitleComponent(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight(),
            title = title,
        )
    }
}