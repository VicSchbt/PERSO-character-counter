package com.example.charactercounter.counting.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.charactercounter.counting.presentation.components.Header
import com.example.charactercounter.ui.theme.CharacterCounterTheme

@Composable
fun CharacterCounterScreen(modifier: Modifier) {


    Column {
        Header(modifier = Modifier)
    }
}

@PreviewLightDark
@Composable
fun CharacterCounterScreenPreview() {
    CharacterCounterTheme {
        CharacterCounterScreen(modifier = Modifier)
    }
}