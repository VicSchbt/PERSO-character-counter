package com.example.charactercounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.charactercounter.counting.presentation.CharacterCounterScreen
import com.example.charactercounter.ui.theme.CharacterCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CharacterCounterTheme {
                Image(
                    painterResource(R.drawable.bg_light_theme),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                ) { innerPadding ->
                    CharacterCounterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

