package com.beardness.wordknight.presentaion.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import com.beardness.wordknight.R
import com.beardness.wordknight.data.wordstype.shortName
import com.beardness.wordknight.ui.widgets.ad.AdBannerWidget
import com.beardness.wordknight.ui.widgets.loading.WordsLoadingWidget
import com.beardness.wordknight.ui.widgets.search.SearchWidget
import com.beardness.wordknight.ui.widgets.toolbar.SearchToolbarWidget

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel,
    navigateToAboutScreen: () -> Unit,
) {
    val words by viewModel.words.collectAsState()
    val wordsType by viewModel.wordsType.collectAsState()

    val isWordsLoading by viewModel.wordsLoading.collectAsState()
    val isWordsTypeLoading by viewModel.toolbarWordsTypeLoading.collectAsState()

    var input by remember { mutableStateOf("") }
    val patternLength by viewModel.patternLength.collectAsState()

    val keyboardController = LocalSoftwareKeyboardController.current

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
            onClickSearch = { pattern ->
                keyboardController?.hide()
                viewModel.filter(pattern = pattern)
            },
            onClickReset = { viewModel.reset() }
        )

        WordsLoadingWidget(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxWidth(),
            isWordsLoading = isWordsLoading,
            patternLength = patternLength,
            words = words,
            copyToClipboard = { value -> viewModel.copyToClipboard(value = value) },
        )

        AdBannerWidget()
    }
}