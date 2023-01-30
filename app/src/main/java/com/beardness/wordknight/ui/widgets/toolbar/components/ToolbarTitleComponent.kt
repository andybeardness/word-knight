package com.beardness.wordknight.ui.widgets.toolbar.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun ToolbarTitleComponent(
    modifier: Modifier,
    title: String,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = title,
            color = WordKnightTheme.colors.white,
            fontWeight = FontWeight.Thin,
            fontSize = 24.sp,
        )
    }
}