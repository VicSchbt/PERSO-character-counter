package com.example.charactercounter.counting.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.charactercounter.R
import com.example.charactercounter.counting.presentation.components.Header
import com.example.charactercounter.counting.presentation.components.LetterDensity
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
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass
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
            if (windowSize == WindowWidthSizeClass.Compact) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
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
                    EstimatedReadingTime(state)
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ResultTiles(state, modifier = Modifier.fillMaxWidth())
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
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
                    EstimatedReadingTime(state)
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ResultTiles(state, modifier = Modifier.weight(1 / 3f))
                }
            }
            if (state.totalLetter > 0) {
                LetterDensity(
                    letterDensity = state.letterDensity,
                    totalLetter = state.totalLetter
                )
            }

        }


    }
}

@Composable
private fun EstimatedReadingTime(state: CharacterCounterState) {
    if (state.estimatedReadingTime != null) {
        Text(
            text = stringResource(R.string.time_reading_label) + state.estimatedReadingTime,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun ResultTiles(state: CharacterCounterState, modifier: Modifier = Modifier) {
    ResultTile(
        value = state.characterCount,
        config = ResultTileConfig.CHARACTER,
        modifier = modifier
    )
    ResultTile(
        value = state.wordCount,
        config = ResultTileConfig.WORD,
        modifier = modifier
    )
    ResultTile(
        value = state.sentenceCount,
        config = ResultTileConfig.SENTENCE,
        modifier = modifier
    )
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_info),
                contentDescription = "warning icon",
                tint = Orange800
            )
            Text(
                text = stringResource(R.string.text_input_character_limit_error, state.exceed),
                style = MaterialTheme.typography.labelSmall,
                color = Orange800
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
                textToAnalyse = "",
                isLimitExceeded = true,
                wordCount = 350,
                characterLimit = 300,
                estimatedReadingTime = "2 min"
            ),
            {},
            modifier = Modifier,
            windowSize = WindowWidthSizeClass.Compact
        )
    }
}