package dev.theananta.edulens.home.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.theananta.edulens.R
import dev.theananta.edulens.data.clubs
import dev.theananta.edulens.data.students
import dev.theananta.edulens.model.User


@Composable
fun DashboardPage(modifier: Modifier = Modifier, student: User.Student = students.first()) {
    var posts = listOf(
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6,
        R.drawable.img_7,
        R.drawable.img_8,
        R.drawable.img_9
    )
    var isAboutGitamDisplayed by remember {
        mutableStateOf(true)
    }
    LazyColumn(modifier = modifier.padding(vertical = 16.dp)) {
        item {
            Greeting(name = student.firstName, modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            ClubsSection(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .padding(horizontal = 6.dp),
                clubs = clubs
            )
        }
        item {
            TopCard(modifier = Modifier.padding(12.dp))
        }
        if(isAboutGitamDisplayed){
            item {
                AboutGITAM{
                    isAboutGitamDisplayed = false
                }
            }
        }
        items(8) {
            PostCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), posts[it]
            )
        }

    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, name: String) {
    Column(modifier = modifier) {
        Text("${stringResource(R.string.ic_hola)}, $name", style = MaterialTheme.typography.headlineSmall)
        Text(stringResource(R.string.here_s_an_overview_of_your_day))
    }
}


@Composable
fun HomePageGraphSection(modifier: Modifier = Modifier) {
    Row {

    }
}

@Composable
fun TopCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.error)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("24", style = MaterialTheme.typography.headlineSmall)
                Text(stringResource(R.string.hours), style = MaterialTheme.typography.labelSmall)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 24.dp)
            ) {
                Text("${stringResource(R.string.assignment)} 05", style = MaterialTheme.typography.titleMedium)
                Text(
                    stringResource(R.string.database_management_system),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text("CSEN2011", style = MaterialTheme.typography.labelSmall)
            }
            IconButton(onClick = {}) {
                Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
            }
        }
    }
}
