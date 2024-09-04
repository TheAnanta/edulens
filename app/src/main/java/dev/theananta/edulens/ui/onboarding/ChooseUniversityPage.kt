package dev.theananta.edulens.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.theananta.edulens.R
import dev.theananta.edulens.data.UniversityPreviewParameterProvider
import dev.theananta.edulens.data.universitiesInVizag
import dev.theananta.edulens.model.University
import dev.theananta.edulens.ui.EduLensLogo
import dev.theananta.edulens.ui.OutlinedDropdownTextField
import dev.theananta.edulens.ui.theme.CondensedTypography
import dev.theananta.edulens.ui.theme.EduLensTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UniversitySelectionPage(
    modifier: Modifier = Modifier,
    selectedUniversity: University? = null,
    universities: List<University> = listOf(),
    onUniversitySelected: (University) -> Unit = {}
) {
    Box {
        Image(
            painter = painterResource(R.drawable.world_splash_background),
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )
        Scaffold(modifier = modifier, containerColor = Color.Transparent) { innerPadding ->
            Column {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(vertical = 40.dp, horizontal = 36.dp)
                ) {
                    EduLensLogo(color = Color(0xFFF0DFC0))
                    Text(
                        text = stringResource(R.string.ic_hola).uppercase(),
                        fontFamily = CondensedTypography,
                        style = MaterialTheme.typography.displayMedium,
                        color = Color(0xFFF0DFC0),
                        modifier = Modifier.padding(top = 24.dp)
                    )
                    Text(
                        stringResource(R.string.university_selection_subtitle),
                        color = Color(0xFFF0DFC0),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    OutlinedDropdownTextField(
                        modifier = Modifier
                            .padding(top = 28.dp)
                            .fillMaxWidth(),
                        options = universities,
                        selected = selectedUniversity?.name,
                        label = stringResource(R.string.institution),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFFF0DFC0),
                            unfocusedBorderColor = Color(0xFFF0DFC0),
                            unfocusedLabelColor = Color(0xFFF0DFC0),
                            focusedLabelColor = Color(0xFFF0DFC0),
                            unfocusedTrailingIconColor = Color(0xFFF0DFC0),
                            focusedTrailingIconColor = Color(0xFFF0DFC0),
                            focusedTextColor = Color(0xFFF0DFC0),
                            unfocusedTextColor = Color(0xFFF0DFC0),
                        )
                    ) {
                        it?.let { university ->
                            onUniversitySelected(university)
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .wrapContentHeight(Alignment.Bottom)
                        .padding(bottom = 14.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Perform duties, detach from results | कर्मण्येवाधिकारस्ते मा फलेषु कदाचन । मा कर्मफलहेतुर्भुर्मा ते संगोऽस्त्वकर्मणि ॥",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(unbounded = false),
                        softWrap = false,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}

@Preview
@Composable
private fun UniversitySelectionPagePreview(@PreviewParameter(UniversityPreviewParameterProvider::class) selectedUniversity: University) {
    EduLensTheme {
        UniversitySelectionPage(
            universities = universitiesInVizag,
            selectedUniversity = selectedUniversity
        ) { selectedUniversity ->

        }
    }
}