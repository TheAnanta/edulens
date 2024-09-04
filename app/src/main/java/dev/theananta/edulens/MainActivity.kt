package dev.theananta.edulens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.theananta.edulens.ui.EduLensNavHost
import dev.theananta.edulens.ui.theme.EduLensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EduLensTheme {
                EduLensNavHost()
            }
        }
    }
}
