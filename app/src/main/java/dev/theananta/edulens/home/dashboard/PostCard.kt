package dev.theananta.edulens.home.dashboard

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.IosShare
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.theananta.edulens.R
import dev.theananta.edulens.ui.theme.EduLensTheme

@Composable
fun PostCard(modifier: Modifier = Modifier, @DrawableRes image: Int) {
    Card(modifier = modifier) {
        Column {
            PostHeader()
            PostContent(image = image)
            PostFooter()
        }
    }
}

@Composable
fun PostContent(modifier: Modifier = Modifier, @DrawableRes image: Int) {
    Image(
        painter = painterResource(image),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentDescription = null
    )
}

@Composable
fun PostFooter(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = {}, modifier = Modifier.padding(6.dp)) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = null)
            }
            IconButton(onClick = {}, modifier = Modifier.padding(6.dp)) {
                Icon(Icons.Outlined.IosShare, contentDescription = null)
            }
            IconButton(onClick = {}, modifier = Modifier.padding(6.dp)) {
                Icon(Icons.Outlined.ChatBubbleOutline, contentDescription = null)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}, modifier = Modifier.padding(6.dp)) {
                Icon(Icons.Outlined.Bookmark, contentDescription = null)
            }
        }
        Text(
            stringResource(R.string.post_card_report),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 24.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun PostHeader(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(16.dp)) {
        ProfilePicture()
        AuthorAndTimeText()
    }
}

@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier, image: String = "https://github.com/ManasMalla.png"
) {
    AsyncImage(
        model = image,
        contentDescription = null,
        modifier = modifier
            .padding(end = 12.dp)
            .size(48.dp)
            .clip(
                CircleShape
            )
    )
}

@Composable
fun AuthorAndTimeText(
    modifier: Modifier = Modifier, author: String = stringResource(R.string.manas_malla), time: String = "1h ago"
) {
    Column(modifier = modifier) {
        Text(author, style = MaterialTheme.typography.titleMedium)
        Text(time, modifier = Modifier.alpha(0.6f))
    }
}

@Preview
@Composable
private fun PostCardPreview() {
    EduLensTheme {
        PostCard(image = R.drawable.img_5)
    }
}