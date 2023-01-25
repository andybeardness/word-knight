package com.beardness.wordknight.presentaion.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel,
    navigateToAboutScreen: () -> Unit,
) {
    val words by viewModel.words.collectAsState()

    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(value = input, onValueChange = { update -> input = update })

        Button(
            onClick = {
                viewModel.filter(pattern = input)
            }
        ) {
            Text(text = "SEARCH")
        }

        Button(
            onClick = {
                input = ""
                viewModel.clear()
            }
        ) {
            Text(text = "CLEAR")
        }

        Button(
            onClick = {
                navigateToAboutScreen()
            }
        ) {
            Text(text = "ABOUT")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(words) { word ->
                Text(text = word, color = Color.Red)
            }
        }
    }
}