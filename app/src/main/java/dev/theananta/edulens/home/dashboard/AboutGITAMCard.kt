package dev.theananta.edulens.home.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.theananta.edulens.R


@Composable
fun AboutGITAM(modifier: Modifier = Modifier, onDismiss: ()->Unit = {}) {
    Card(modifier = Modifier.padding(horizontal = 12.dp)) {
        Column(modifier = modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.about_gitam),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                TextButton(onClick = onDismiss) {
                    Text(stringResource(R.string.dismiss))
                }
            }
            Text(
                stringResource(R.string.about_gitam_text).trimIndent(),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(R.string.mission), style = MaterialTheme.typography.titleMedium)
                    Text(stringResource(R.string.gitam_mission), style = MaterialTheme.typography.bodyMedium)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(R.string.vision), style = MaterialTheme.typography.titleMedium)
                    Text(
                        stringResource(R.string.gitam_vission),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}