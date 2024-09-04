package dev.theananta.edulens.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Login
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.theananta.edulens.R
import dev.theananta.edulens.model.University
import dev.theananta.edulens.ui.theme.CondensedTypography
import dev.theananta.edulens.ui.theme.EduLensTheme
import dev.theananta.edulens.ui.theme.universityOnPrimary
import dev.theananta.edulens.ui.theme.universityPrimaryColor

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    university: University = University(
        "GITAM (Deemed to Be University)",
        "",
        "gitam-vsp"
    ),
    onScanId: () -> Unit = {},
    onSignUp: (String, String) -> Unit = { _u, _p -> }
) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = modifier
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
                    contentDescription = university.name + " logo",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                )
                Text(
                    "Welcome to ${university.name.split("(").first()}".uppercase(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = CondensedTypography,
                    modifier = Modifier.padding(top = 24.dp)
                )
                Text(
                    stringResource(R.string.login).uppercase(),
                    style = MaterialTheme.typography.displayMedium,
                    fontFamily = CondensedTypography,
                )
                Text(
                    stringResource(R.string.login_subtitle),
                    style = MaterialTheme.typography.bodyMedium,
                )
                TextField(value = username, onValueChange = {
                    username = it
                }, label = {
                    Text("@username")
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .padding(top = 24.dp)
                )
                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text("password")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                Row(modifier = Modifier.padding(vertical = 16.dp)) {
                    OutlinedButton(
                        onClick = onScanId,
                    ) {
                        Text(stringResource(R.string.scan_id_card))
                    }
                    Button(
                        modifier = Modifier.padding(start = 12.dp),
                        onClick = {
                            onSignUp(username, password)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.Login,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .size(16.dp)
                        )
                        Text(stringResource(R.string.login))
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .align(
                        Alignment.BottomCenter
                    ),
                tonalElevation = 16.dp,
                color = MaterialTheme.colorScheme.universityPrimaryColor
            ) {

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(
                        Alignment.BottomCenter
                    ), verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 28.dp, horizontal = 14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Text(
                        "©  ${university.name} 2024. All Rights Reserved",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                            .padding(top = 28.dp)
                            .fillMaxWidth(0.5f),
                        color = MaterialTheme.colorScheme.universityOnPrimary
                    )
                }
                Image(
                    painter = painterResource(R.drawable.study_group),
                    contentDescription = null,
                    modifier = Modifier
                        .scale(1.4f)
                        .weight(1f),
                )
            }


        }
    }
}

@Preview
@Composable
private fun LoginPagePreview() {
    EduLensTheme {
        LoginPage()
    }
}