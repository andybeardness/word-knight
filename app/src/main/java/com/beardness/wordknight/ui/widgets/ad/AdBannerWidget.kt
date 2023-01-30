package com.beardness.wordknight.ui.widgets.ad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.beardness.wordknight.BuildConfig
import com.beardness.wordknight.ui.theme.WordKnightTheme
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdBannerWidget() {
    val bannerId =
        if (BuildConfig.DEBUG) {
            "ca-app-pub-3940256099942544/6300978111"
        } else {
            "ca-app-pub-3615977563460088/2202552547"
        }

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 64.dp)
            .background(color = WordKnightTheme.colors.card),
        factory = { context ->
            AdView(context)
                .apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = bannerId
                    loadAd(AdRequest.Builder().build())
                }
        }
    )
}