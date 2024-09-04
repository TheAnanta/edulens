package dev.theananta.edulens.ui.onboarding

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Login
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import dev.theananta.edulens.R
import dev.theananta.edulens.model.University
import dev.theananta.edulens.ui.theme.CondensedTypography
import dev.theananta.edulens.ui.theme.EduLensTheme
import dev.theananta.edulens.ui.theme.HeadlineTypography
import dev.theananta.edulens.ui.theme.universityOnPrimary
import dev.theananta.edulens.ui.theme.universityPrimaryColor
import dev.theananta.edulens.ui.theme.universityPrimaryContainerColor
import kotlinx.coroutines.delay

@Composable
fun AuthenticationPage(
    modifier: Modifier = Modifier,
    university: University = University("GITAM (Deemed to Be University)", "", "gitam-vsp"),
    onScanId: () -> Unit = {},
    navigateToSignUp: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier, containerColor = MaterialTheme.colorScheme.universityPrimaryColor
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            Column(
                modifier = Modifier
                    .padding(28.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.cats_logo_white),
                    modifier = Modifier.size(48.dp),
                    contentDescription = university.name + " logo"
                )
                Text(
                    stringResource(R.string.welcome_to) + university.name.split("(").first()
                        .uppercase(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = CondensedTypography,
                    color = MaterialTheme.colorScheme.universityOnPrimary.copy(alpha = 0.6f),
                    modifier = Modifier.padding(top = 24.dp)
                )
                Text(
                    stringResource(R.string.get_started).uppercase(),
                    style = MaterialTheme.typography.displayMedium,
                    fontFamily = CondensedTypography,
                    color = MaterialTheme.colorScheme.universityOnPrimary
                )
                Text(
                    stringResource(R.string.login_subtitle),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.universityOnPrimary,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                Row(modifier = Modifier.padding(vertical = 16.dp)) {
                    OutlinedButton(
                        onClick = onScanId,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.universityOnPrimary)
                    ) {
                        Text(stringResource(R.string.scan_id_card))
                    }
                    Button(
                        modifier = Modifier.padding(start = 12.dp),
                        onClick = navigateToSignUp,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.universityOnPrimary,
                            contentColor = MaterialTheme.colorScheme.universityPrimaryColor
                        )
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.Login,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .size(16.dp)
                        )
                        Text(stringResource(R.string.sign_up))
                    }
                }
            }
            Image(
                painter = painterResource(R.drawable.study_group),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(
                        Alignment.BottomCenter
                    )
                    .scale(1.3f)
                    .padding(bottom = 56.dp)
            )
            Surface(
                modifier = Modifier.align(
                    Alignment.BottomCenter
                ),
                tonalElevation = 16.dp,
                color = MaterialTheme.colorScheme.universityPrimaryContainerColor
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    UniversityCourseOfferingsInfiniteScroll()
                    Text(
                        "©  ${university.name} 2024. All Rights Reserved",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(top = 28.dp),
                        color = MaterialTheme.colorScheme.universityOnPrimary
                    )
                }
            }
        }
    }
}

@Composable
private fun UniversityCourseOfferingsInfiniteScroll() {
    val scrollPosition = remember { Animatable(0f) }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            scrollPosition.animateTo(
                targetValue = 500f, animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 20000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
            delay(20000) // Delay for the reverse animation
        }
    }

    // Content
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(3) { index -> // 3 items in your example
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset {
                        IntOffset(
                            if (index % 2 == 0) scrollPosition.value.toInt() else -(scrollPosition.value.toInt()),
                            0
                        )
                    }, horizontalArrangement = Arrangement.spacedBy(4.dp) // Add spacing
            ) {

                Text(
                    "humanitaries • computer science engineering • biotechnology • venture development pharmacy • dental • mbbs • artificial intelligence".uppercase(),
                    fontFamily = HeadlineTypography,
                    color = MaterialTheme.colorScheme.universityOnPrimary,
                    modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                        .padding(vertical = 10.dp),
                    softWrap = false,
                )

            }
        }
    }
}

@Preview
@Composable
private fun AuthenticationPagePreview() {
    EduLensTheme {
        AuthenticationPage()
    }
}