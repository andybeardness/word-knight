package com.beardness.wordknight.ui.widgets.search.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.beardness.wordknight.ui.theme.WordKnightTheme

@Composable
fun TextInputComponent(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    colors: TextFieldColors,
    placeHolderTitle: String,
    onClickSearch: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value.uppercase(),
        onValueChange = onValueChange,
        colors = colors,
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Light,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = { onClickSearch(value) },
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = placeHolderTitle,
                color = WordKnightTheme.colors.white.copy(alpha = .5f),
                fontWeight = FontWeight.Thin,
            )
        }
    )
}