package com.beardness.wordknight.ui.widgets.description

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun DescriptionWidget(
    title: String,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp,
            )
            .background(
                color = WordKnightTheme.colors.card,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            )
    ) {
        Text(
            text = title.uppercase(),
            color = WordKnightTheme.colors.white,
            fontSize = 40.sp,
            fontWeight = FontWeight.Thin,
        )

        content()
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_DescriptionWidget() {
    DescriptionWidget(
        title = "Header",
        content = {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                color = WordKnightTheme.colors.white,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 16.sp,
            )
        }
    )
}