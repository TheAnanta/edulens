package dev.theananta.edulens.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.theananta.edulens.model.University

val universitiesInVizag = listOf(
    University(name = "GITAM University", logo = "", id = "gitam-vsp"),
    University(name = "Andhra University", logo = "", id = "andhra-vsp"),
    University(name = "Chapra University", logo = "", id = "chapra-bhr"),
    University(name = "LP University", logo = "", id = "lp-pnj"),
    University(name = "Manipal University", logo = "", id = "manipal-dl"),
    University(name = "KL University", logo = "", id = "kl-hyd"),
)

class UniversityPreviewParameterProvider : PreviewParameterProvider<University?> {
    override val values = sequenceOf(null, universitiesInVizag[0])
}