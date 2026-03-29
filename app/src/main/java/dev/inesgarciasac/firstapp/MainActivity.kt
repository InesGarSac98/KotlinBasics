package dev.inesgarciasac.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.inesgarciasac.firstapp.layouts.BoxLayout
import dev.inesgarciasac.firstapp.layouts.ScaffoldLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldLayout()
        }
    }
}
