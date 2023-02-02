package com.beardness.wordknight.ui.widgets.description.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.beardness.wordknight.R
import com.beardness.wordknight.ui.theme.WordKnightTheme
import com.beardness.wordknight.utils.common.httpsLinkPretty

@Composable
fun PolicyDescriptionComponent() {
    val policyUrl = stringResource(id = R.string.policy_url)
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(policyUrl)) }

    val policyUrlClean = policyUrl.httpsLinkPretty()

    Text(
        modifier = Modifier
            .clickable { context.startActivity(intent) },
        text = policyUrlClean,
        color = WordKnightTheme.colors.yellow,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 16.sp,
    )
}