package com.beardness.wordknight.ui.widgets.toolbar.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Sync
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun LoadingWordsTypeComponent(
    isWordsTypeLoading: Boolean,
    currentWordsTypeTitle: String,
    onClickWordsType: () -> Unit,
) {
    var angle by remember { mutableStateOf(value = 0f) }

    val rotation = remember { Animatable(angle) }

    LaunchedEffect(key1 = isWordsTypeLoading) {
        if (isWordsTypeLoading) {
            rotation.animateTo(
                targetValue = angle - 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1000,
                        easing = LinearEasing,
                    ),
                )
            ) {
                angle = value
            }
        }
    }

    if (isWordsTypeLoading) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(width = 64.dp),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier
                    .rotate(degrees = angle),
                imageVector = Icons.Rounded.Sync,
                contentDescription = "",
                tint = WordKnightTheme.colors.white
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(width = 64.dp)
                .clickable { onClickWordsType() },
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = currentWordsTypeTitle,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = WordKnightTheme.colors.white,
            )
        }
    }
}