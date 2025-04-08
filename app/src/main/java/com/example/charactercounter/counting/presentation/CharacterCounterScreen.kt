package com.example.charactercounter.counting.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.charactercounter.R
import com.example.charactercounter.counting.presentation.components.Header
import com.example.charactercounter.counting.presentation.components.ResultTile
import com.example.charactercounter.counting.presentation.components.TextInput
import com.example.charactercounter.counting.presentation.components.TextOptions
import com.example.charactercounter.counting.presentation.components.Title
import com.example.charactercounter.counting.presentation.components.config.ResultTileConfig
import com.example.charactercounter.ui.theme.CharacterCounterTheme
import com.example.charactercounter.ui.theme.Orange800

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
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            UserTextInput(state, onAction)
            TextOptions(
                isBlankSpaceExcluded = state.isBlankSpaceExcluded,
                onIsBlankSpaceExcludedChange = {
                    onAction(
                        CharacterCounterAction.OnIsBlankSpaceExcludedChange(it)
                    )
                },
                isCharacterLimitEnabled = state.isCharacterLimitEnabled,
                onCharacterLimitEnabledChange = {
                    onAction(
                        CharacterCounterAction.OnCharacterLimitEnabledChange(it)
                    )
                },
                characterLimit = state.characterLimit?.toString().orEmpty(),
                onCharacterLimitChange = {
                    onAction(
                        CharacterCounterAction.OnCharacterLimitChange(it)
                    )
                }
            )
        }

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

@Composable
private fun UserTextInput(
    state: CharacterCounterState,
    onAction: (CharacterCounterAction) -> Unit
) {
    TextInput(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(200.dp),
        textValue = state.textToAnalyse,
        onTextValueChange = { onAction(CharacterCounterAction.OnTextChange(it)) }
    )
    if (state.isLimitExceeded && state.characterLimit != null) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(
                painter = painterResource(R.drawable.icon_info),
                contentDescription = "warning icon",
                tint = Orange800
            )
            Text(text= stringResource(R.string.text_input_character_limit_error, state.exceed),
                style = MaterialTheme.typography.labelSmall,
                color = Orange800)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterCounterScreenPreview() {
    CharacterCounterTheme {
        CharacterCounterScreen(
            state = CharacterCounterState(
                textToAnalyse = "",
                isLimitExceeded = true,
                wordCount = 350,
                characterLimit = 300
            ),
            {},
            modifier = Modifier
        )
    }
}