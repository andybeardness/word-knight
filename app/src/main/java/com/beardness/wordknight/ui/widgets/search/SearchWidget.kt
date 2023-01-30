package com.beardness.wordknight.ui.widgets.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beardness.wordknight.R
import com.beardness.wordknight.ui.theme.WordKnightTheme
import com.beardness.wordknight.ui.widgets.search.components.ResetButtonComponent
import com.beardness.wordknight.ui.widgets.search.components.SearchButtonComponent
import com.beardness.wordknight.ui.widgets.search.components.TextInputComponent

@Composable
fun SearchWidget(
    value: String,
    onValueChange: (String) -> Unit,
    onClickSearch: (String) -> Unit,
    onClickReset: () -> Unit,
) {
    val haptic = LocalHapticFeedback.current

    val colors = TextFieldDefaults.textFieldColors(
        textColor = WordKnightTheme.colors.white,
        backgroundColor = WordKnightTheme.colors.background,
        cursorColor = WordKnightTheme.colors.cyan,
        focusedIndicatorColor = WordKnightTheme.colors.background,
        disabledIndicatorColor = WordKnightTheme.colors.background,
        unfocusedIndicatorColor = WordKnightTheme.colors.background,
    )

    val placeHolderTitle = stringResource(id = R.string.enter_pattern)

    Row(
        modifier = Modifier
            .background(color = WordKnightTheme.colors.background)
            .fillMaxWidth()
            .height(height = 64.dp)
    ) {
        TextInputComponent(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight(),
            value = value.uppercase(),
            onValueChange = onValueChange,
            colors = colors,
            placeHolderTitle = placeHolderTitle,
        )

        ResetButtonComponent(
            onClickReset = {
                onClickReset()
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        )

        SearchButtonComponent(
            onClickSearch = {
                onClickSearch(value)
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        )
    }
}

@Composable
@Preview
fun Preview_SearchWidget_0() {
    SearchWidget(
        value = "Example Text",
        onValueChange = {},
        onClickSearch = {},
        onClickReset = {},
    )
}

@Composable
@Preview
fun Preview_SearchWidget_1() {
    SearchWidget(
        value = "",
        onValueChange = {},
        onClickSearch = {},
        onClickReset = {},
    )
}