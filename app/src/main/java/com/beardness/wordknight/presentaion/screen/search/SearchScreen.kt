package com.beardness.wordknight.presentaion.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.beardness.wordknight.R
import com.beardness.wordknight.data.wordstype.shortName
import com.beardness.wordknight.ui.widgets.ad.AdBannerWidget
import com.beardness.wordknight.ui.widgets.search.SearchWidget
import com.beardness.wordknight.ui.widgets.toolbar.SearchToolbarWidget
import com.beardness.wordknight.ui.widgets.word.WordsWidget

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel,
    navigateToAboutScreen: () -> Unit,
) {
    val words by viewModel.words.collectAsState()
    val wordsType by viewModel.wordsType.collectAsState()

    val isWordsTypeLoading by viewModel.toolbarWordsTypeLoading.collectAsState()

    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchToolbarWidget(
            title = stringResource(id = R.string.app_name),
            currentWordsTypeTitle = wordsType.shortName,
            isWordsTypeLoading = isWordsTypeLoading,
            onClickWordsType = { viewModel.changeWordsType() },
            onClickAbout = { navigateToAboutScreen() },
        )

        SearchWidget(
            value = input,
            onValueChange = { update -> input = update },
            onClickSearch = { pattern -> viewModel.filter(pattern = pattern) },
            onClickReset = { viewModel.reset() }
        )

        WordsWidget(
            modifier = Modifier
                .weight(weight = 1f),
            words = words,
            copyToClipboard = { value -> viewModel.copyToClipboard(value = value) },
        )

        AdBannerWidget()
    }
}