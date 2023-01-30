package com.beardness.wordknight.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.beardness.wordknight.R
import com.beardness.wordknight.data.wordstype.localeToWordsType
import com.beardness.wordknight.navigation.Navigation
import com.beardness.wordknight.ui.theme.WordKnightTheme
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        compose()
        collects()
    }

    private fun setup() {
        setupAds()
        setupWordsType()
    }

    private fun setupAds() {
        MobileAds.initialize(this)
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
                    color = WordKnightTheme.colors.background,
                ) {
                    Navigation()
                }
            }
        }
    }

    private fun collects() {
        collectCopyToClipboard()
    }

    private fun collectCopyToClipboard() {
        lifecycleScope.launch {
            viewModel.copyToClipboard.collect { value ->
                value ?: return@collect

                val clipboardManager =
                    getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

                val clip = ClipData.newPlainText("word", value)

                clipboardManager.setPrimaryClip(clip)
            }
        }
    }
}