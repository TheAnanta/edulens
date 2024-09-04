package dev.theananta.edulens.home.course

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.theananta.edulens.R
import dev.theananta.edulens.ui.theme.EduLensTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursePage(
    modifier: Modifier = Modifier,
    course: Course = Course(
        "Software Engineering",
        "CSEN1131",
        0.85f,
        description = "",
        time = "08:00"
    ), navigateUp: () -> Unit = {}
) {
    Scaffold(modifier = modifier, topBar = {
        LargeTopAppBar(title = {
            Column {
                Text(course.courseId, style = MaterialTheme.typography.titleMedium)
                Text(course.name)
            }
        }, navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = null)
            }
        })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                modifier = modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("5", style = MaterialTheme.typography.headlineSmall)
                        Text("marks", style = MaterialTheme.typography.labelSmall)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 24.dp)
                    ) {
                        Text("${stringResource(R.string.assignment)} 05", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "9th September 2024",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text("Upload", style = MaterialTheme.typography.labelSmall)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("10", style = MaterialTheme.typography.headlineSmall)
                        Text("marks", style = MaterialTheme.typography.labelSmall)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 24.dp)
                    ) {
                        Text("${stringResource(R.string.quiz)}  03", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "12th September 2024",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            "Multiple Choice Questions",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("5", style = MaterialTheme.typography.headlineSmall)
                        Text("marks", style = MaterialTheme.typography.labelSmall)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 24.dp)
                    ) {
                        Text("${stringResource(R.string.assignment)}  04", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "3th September 2024",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text("Uploaded", style = MaterialTheme.typography.labelSmall)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Rounded.Visibility, contentDescription = null)
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("8/10", style = MaterialTheme.typography.headlineSmall)
                        Text("marks", style = MaterialTheme.typography.labelSmall)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 24.dp)
                    ) {
                        Text("${stringResource(R.string.quiz)}  02", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "2nd September 2024",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            "Multiple Choice Questions",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Rounded.Visibility, contentDescription = null)
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("5/5", style = MaterialTheme.typography.headlineSmall)
                        Text("marks", style = MaterialTheme.typography.labelSmall)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 24.dp)
                    ) {
                        Text("${stringResource(R.string.assignment)}  03", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "29th August 2024",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text("Marks posted", style = MaterialTheme.typography.labelSmall)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Rounded.Visibility, contentDescription = null)
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("10/10", style = MaterialTheme.typography.headlineSmall)
                        Text("marks", style = MaterialTheme.typography.labelSmall)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 24.dp)
                    ) {
                        Text("${stringResource(R.string.quiz)}  01", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "12th August 2024",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            "Multiple Choice Questions",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Rounded.Visibility, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CoursePagePreview() {
    EduLensTheme {
        CoursePage()
    }
}