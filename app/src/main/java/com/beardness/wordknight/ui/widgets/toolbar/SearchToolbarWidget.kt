package com.beardness.wordknight.ui.widgets.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beardness.wordknight.ui.theme.WordKnightTheme
import com.beardness.wordknight.ui.widgets.toolbar.components.AboutButtonComponent
import com.beardness.wordknight.ui.widgets.toolbar.components.ToolbarTitleComponent
import com.beardness.wordknight.ui.widgets.toolbar.components.LoadingWordsTypeComponent

@Composable
fun SearchToolbarWidget(
    title: String,
    currentWordsTypeTitle: String,
    isWordsTypeLoading: Boolean,
    onClickWordsType: () -> Unit,
    onClickAbout: () -> Unit,
) {
    val haptic = LocalHapticFeedback.current

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

        LoadingWordsTypeComponent(
            isWordsTypeLoading = isWordsTypeLoading,
            currentWordsTypeTitle = currentWordsTypeTitle,
            onClickWordsType = {
                onClickWordsType()
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        )

        AboutButtonComponent(
            onClickAbout = {
                onClickAbout()
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_SearchToolbarWidget() {
    SearchToolbarWidget(
        title = "Test Title",
        currentWordsTypeTitle = "RU",
        isWordsTypeLoading = false,
        onClickWordsType = {},
        onClickAbout = {},
    )
}