package com.example.charactercounter.counting.presentation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.charactercounter.counting.presentation.components.Header
import com.example.charactercounter.counting.presentation.components.ResultTile
import com.example.charactercounter.counting.presentation.components.TextInput
import com.example.charactercounter.counting.presentation.components.Title
import com.example.charactercounter.counting.presentation.components.config.ResultTileConfig
import com.example.charactercounter.ui.theme.CharacterCounterTheme

@Composable
fun CharacterCounterScreen(
    state: CharacterCounterState,
    onAction: (CharacterCounterAction) -> Unit,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ) {
        Header(modifier = Modifier)
        Title(modifier = Modifier)
        TextInput(
            modifier = Modifier.fillMaxWidth()
                .requiredHeight(200.dp),
            textValue = state.textToAnalyse,
            onTextValueChange = {onAction(CharacterCounterAction.OnTextChange(it))}
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ResultTile(
                value = state.characterCount,
                config = ResultTileConfig.CHARACTER
            )
            ResultTile(
                value = state.wordCount,
                config = ResultTileConfig.WORD
            )
            ResultTile(
                value = state.sentenceCount,
                config = ResultTileConfig.SENTENCE
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterCounterScreenPreview() {
    CharacterCounterTheme {
        CharacterCounterScreen(
            state = CharacterCounterState(
                textToAnalyse = ""
            ),
            {},
            modifier = Modifier
        )
    }
}