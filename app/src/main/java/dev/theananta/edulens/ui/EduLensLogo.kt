package dev.theananta.edulens.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.theananta.edulens.R
import dev.theananta.edulens.ui.theme.EduLensTheme
import dev.theananta.edulens.ui.theme.NexaFontFamily

@Composable
fun EduLensLogo(modifier: Modifier = Modifier, color: Color? = null) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Outlined.LocalLibrary,
            contentDescription = null,
            tint = color ?: MaterialTheme.colorScheme.primary
        )
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(
                stringResource(R.string.app_name).uppercase(),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = color ?: MaterialTheme.colorScheme.primary,
                    fontFamily = NexaFontFamily, fontWeight = FontWeight.W900
                ), lineHeight = 8.sp, modifier = Modifier.offset(y = (2).dp)
            )
            Text(
                stringResource(R.string.theanantainitiave),
                style = MaterialTheme.typography.labelSmall.copy(
                    color = color ?: MaterialTheme.colorScheme.primary,
                    fontFamily = NexaFontFamily
                ), modifier = Modifier.offset(y = (-2).dp)
            )
        }
    }
}

@Preview
@Composable
fun EduLensLogoPreview(modifier: Modifier = Modifier) {
    EduLensTheme {
        EduLensLogo()
    }
}