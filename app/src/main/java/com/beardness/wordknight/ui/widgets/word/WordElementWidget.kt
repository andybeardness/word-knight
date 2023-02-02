package com.beardness.wordknight.ui.widgets.word

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CopyAll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun WordElementWidget(
    title: String,
    copyButtonColor: Color,
    onClickCopy: (String) -> Unit
) {
    val size = 40.dp
    val cornerRound = 10.dp

    val startShape = RoundedCornerShape(
        topStart = cornerRound,
        bottomStart = cornerRound,
    )

    val endShape = RoundedCornerShape(
        topEnd = cornerRound,
        bottomEnd = cornerRound,
    )

    val haptic = LocalHapticFeedback.current

    Row(
        modifier = Modifier
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp,
            )
            .height(height = size)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
                .background(
                    color = WordKnightTheme.colors.card,
                    shape = startShape,
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    ),
                text = title.uppercase(),
                color = WordKnightTheme.colors.white,
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
            )
        }

        Box(
            modifier = Modifier
                .background(
                    color = copyButtonColor,
                    shape = endShape,
                )
                .fillMaxHeight()
                .width(width = size)
                .clip(shape = endShape)
                .clickable {
                    onClickCopy(title)
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Rounded.CopyAll,
                contentDescription = "",
                tint = WordKnightTheme.colors.white
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_WordElementWidget() {
    WordElementWidget(
        title = "word",
        onClickCopy = {},
        copyButtonColor = WordKnightTheme.colors.blue,
    )
}