package com.beardness.wordknight.ui.widgets.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun LoadingWidget(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.AccessTime,
            contentDescription = "",
            tint = WordKnightTheme.colors.white,
            modifier = Modifier
                .size(size = 48.dp)
        )
    }
}