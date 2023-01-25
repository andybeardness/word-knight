package com.beardness.wordknight.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.beardness.wordknight.R
import com.beardness.wordknight.data.wordstype.localeToWordsType
import com.beardness.wordknight.navigation.Navigation
import com.beardness.wordknight.ui.theme.WordKnightTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        compose()
    }

    private fun setup() {
        setupWordsType()
    }

    private fun setupWordsType() {
        val wordsType =
            getString(R.string.locale)
                .localeToWordsType()

        viewModel.setupWords(wordsType = wordsType)
    }

    private fun compose() {
        setContent {
            WordKnightTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}