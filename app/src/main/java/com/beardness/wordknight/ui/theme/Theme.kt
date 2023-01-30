package com.beardness.wordknight.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.beardness.wordknight.ui.theme.colors.CustomColors
import com.beardness.wordknight.ui.theme.colors.LocalCustomColors
import com.beardness.wordknight.ui.theme.colors.customColors
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WordKnightTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = WordKnightTheme.colors.card,
    )

    val colors = customColors

    CompositionLocalProvider(
        LocalCustomColors provides colors,
        content = content
    )
}

object WordKnightTheme {
    val colors: CustomColors
        @Composable
        get() = LocalCustomColors.current
}