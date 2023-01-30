package com.beardness.wordknight.ui.theme.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val white: Color,
    val background: Color,
    val card: Color,
    val red: Color,
    val orange: Color,
    val yellow: Color,
    val green: Color,
    val cyan: Color,
    val blue: Color,
    val purple: Color,
    val pink: Color,
    val coral: Color,
)

val customColors = CustomColors(
    white = Color(color = 0xFFFFFFFF),
    background = Color(color = 0xFF121212),
    card = Color(color = 0xFF272727),
    red = Color(color = 0xFFFF453A),
    orange = Color(color = 0xFFFF9500),
    yellow = Color(color = 0xFFFFCC00),
    green = Color(color = 0xFF34C759),
    cyan = Color(color = 0xFF5AC8FA),
    blue = Color(color = 0xFF0A84FF),
    purple = Color(color = 0xFF5856D6),
    pink = Color(color = 0xFFAF52DE),
    coral = Color(color = 0xFFFF2D55),
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        white = Color(color = 0xFFFFFFFF),
        background = Color(color = 0xFF121212),
        card = Color(color = 0xFF272727),
        red = Color(color = 0xFFFF453A),
        orange = Color(color = 0xFFFF9500),
        yellow = Color(color = 0xFFFFCC00),
        green = Color(color = 0xFF34C759),
        cyan = Color(color = 0xFF5AC8FA),
        blue = Color(color = 0xFF0A84FF),
        purple = Color(color = 0xFF5856D6),
        pink = Color(color = 0xFFAF52DE),
        coral = Color(color = 0xFFFF2D55),
    )
}