package dev.theananta.edulens.ui.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.HelpCenter
import androidx.compose.material.icons.rounded.AssignmentInd
import androidx.compose.material.icons.rounded.AutoGraph
import androidx.compose.material.icons.rounded.SentimentDissatisfied
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import dev.theananta.edulens.R
import dev.theananta.edulens.data.students
import dev.theananta.edulens.model.User
import dev.theananta.edulens.ui.theme.EduLensTheme

@Composable
fun ProfilePage(modifier: Modifier = Modifier, user: User.Student = students.get(0)) {
    Scaffold(modifier = modifier) { innerPadding ->
        Box {
            AsyncImage(
                model = "https://www.gitam.edu/sites/default/files/2023-09/why%20Gitam_0.webp",
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .offset(y = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = user.image,
                    contentDescription = null,
                    placeholder = painterResource(
                        R.drawable.ic_launcher_background
                    ),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(8.dp, MaterialTheme.colorScheme.surface, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    user.firstName + " " + user.lastName,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(user.email + " | " + user.rollNumber)
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    val context = LocalContext.current
                    Text("Achievement", style = MaterialTheme.typography.titleLarge)
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        items(
                            listOf(
                                "https://developers.google.com/static/profile/badges/events/community/solution-challenge/2024/submitted/badge.svg" to "Solution Challenge '24",
                                "https://developers.google.com/static/profile/badges/playlists/android/android-basics-compose-unit-8-pathway-2/badge.svg" to "Compose Views",
                                "https://developers.google.com/static/profile/badges/playlists/android/android-basics-compose-unit-5-pathway-2/badge.svg" to "Adding images"
                            )
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                AsyncImage(
                                    imageLoader = ImageLoader.Builder(context)
                                        .components {
                                            add(SvgDecoder.Factory())
                                        }
                                        .build(),
                                    model = it.first,
                                    contentDescription = null,
                                    modifier = Modifier.size(70.dp),
                                    placeholder = painterResource(R.drawable.cats_logo_white)
                                )
                                Text(
                                    it.second,
                                    style = MaterialTheme.typography.labelSmall,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    val context = LocalContext.current
                    Text("Faculty", style = MaterialTheme.typography.titleLarge)
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .wrapContentHeight()
                    ) {
                        items(
                            listOf(
                                "https://staffphotosweb.gitam.edu/faculty/500621.jpg" to "Mr. Kranthi Kiran",
                                "https://edgroom-authors.s3.ap-south-1.amazonaws.com/https%3A//www.edgroom.com/uploads/authors/202308291916142600063_whatsapp_image_2023_06_05_at_09_35_15.jpg" to "Dr. Soujanya Duvvi",
                                "https://media.licdn.com/dms/image/C4D03AQEksXaoNghBoQ/profile-displayphoto-shrink_200_200/0/1606242035316?e=2147483647&v=beta&t=o3OXV3rhhEexK1d1FPdjlpVZG9_DFtbVGGk-y7ADm2E" to "Dr. Satyabrata Dash",
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCFYU4EUN7Xp4-e92JeCUrOCt0aWGD0wjTrA&s" to "Mrs. Jyotsana Rani",
                            )
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.wrapContentHeight()) {
                                AsyncImage(
                                    imageLoader = ImageLoader.Builder(context)
                                        .components {
                                            add(SvgDecoder.Factory())
                                        }
                                        .build(),
                                    model = it.first,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(70.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.TopCenter,
                                    placeholder = painterResource(R.drawable.cats_logo_white)
                                )
                                Text(
                                    it.second,
                                    style = MaterialTheme.typography.labelSmall,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    ListItem(headlineContent = {
                        Text(stringResource(R.string.results))
                    }, trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                        }
                    }, leadingContent = {
                        Icon(Icons.Rounded.AutoGraph, contentDescription = null)
                    })
                    HorizontalDivider()
                    ListItem(headlineContent = {
                        Text(stringResource(R.string.resume))
                    }, trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                        }
                    }, leadingContent = {
                        Icon(Icons.Rounded.AssignmentInd, contentDescription = null)
                    })
                    HorizontalDivider()
                    ListItem(headlineContent = {
                        Text(stringResource(R.string.query_community))
                    }, trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                        }
                    }, leadingContent = {
                        Icon(Icons.AutoMirrored.Rounded.HelpCenter, contentDescription = null)
                    })
                    HorizontalDivider()
                    ListItem(headlineContent = {
                        Text(stringResource(R.string.raise_an_issue))
                    }, trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                        }
                    }, leadingContent = {
                        Icon(Icons.Rounded.SentimentDissatisfied, contentDescription = null)
                    })
                }

            }
        }
    }
}

@Preview
@Composable
private fun ProfilePagePreview() {
    EduLensTheme {
        ProfilePage()
    }
}