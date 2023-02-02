package com.beardness.wordknight.presentaion.screen.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.beardness.wordknight.R
import com.beardness.wordknight.ui.widgets.description.DescriptionWidget
import com.beardness.wordknight.ui.widgets.description.components.DefaultDescriptionComponent
import com.beardness.wordknight.ui.widgets.description.components.PolicyDescriptionComponent
import com.beardness.wordknight.ui.widgets.toolbar.AboutToolbarWidget

@Composable
fun AboutScreen(
    viewModel: AboutScreenViewModel,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        AboutToolbarWidget(
            title = stringResource(id = R.string.about),
        )

        Column(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            DescriptionWidget(title = stringResource(id = R.string.motivation_title)) {
                DefaultDescriptionComponent(text = stringResource(id = R.string.motivation_text))
            }

            DescriptionWidget(title = stringResource(id = R.string.how_title)) {
                DefaultDescriptionComponent(text = stringResource(id = R.string.how_text))
            }

            DescriptionWidget(title = stringResource(id = R.string.example_title)) {
                DefaultDescriptionComponent(text = stringResource(id = R.string.example_text))
            }

            DescriptionWidget(title = stringResource(id = R.string.policy_title)) {
                PolicyDescriptionComponent()
            }
        }
    }
}