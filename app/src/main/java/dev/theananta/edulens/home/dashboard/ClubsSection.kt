package dev.theananta.edulens.home.dashboard

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import dev.theananta.edulens.R
import dev.theananta.edulens.model.Club


@Composable
fun ClubsSection(modifier: Modifier = Modifier, clubs: List<Club> = listOf()) {
    val context = LocalContext.current
    LazyRow(modifier = modifier) {
        items(clubs) { club ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    imageLoader = ImageLoader.Builder(context)
                        .components {
                            add(SvgDecoder.Factory())
                        }
                        .build(),
                    model = club.image,
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        .padding(6.dp)
                        .clip(
                            CircleShape
                        )
                        .size(56.dp)
                )
                Text(club.name, style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}

@Composable
fun ClubPage(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) { }
    }
}