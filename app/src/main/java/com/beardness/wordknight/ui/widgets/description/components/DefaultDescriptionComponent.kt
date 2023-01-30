package com.beardness.wordknight.ui.widgets.description.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun DefaultDescriptionComponent(
    text: String
) {
    Text(
        text = text,
        color = WordKnightTheme.colors.white,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 16.sp,
    )
}