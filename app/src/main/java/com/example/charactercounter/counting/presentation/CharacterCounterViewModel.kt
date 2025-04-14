package com.example.charactercounter.counting.presentation

import androidx.lifecycle.ViewModel
import com.example.charactercounter.counting.domain.TextAnalysisResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharacterCounterViewModel : ViewModel() {
    private val _state = MutableStateFlow(CharacterCounterState())
    val state = _state.asStateFlow()

    fun onAction(action: CharacterCounterAction) {
        when (action) {
            is CharacterCounterAction.OnTextChange -> onTextChange(action.newText)
            is CharacterCounterAction.OnIsBlankSpaceExcludedChange -> onTextOptionChange(action.isExcluded)
            is CharacterCounterAction.OnCharacterLimitChange -> {
                onCharacterLimitChange(action.value)
            }

            is CharacterCounterAction.OnCharacterLimitEnabledChange -> onCharacterLimitEnabledChange(
                action.enabled
            )
        }
    }

    private fun onCharacterLimitChange(
        value: String?
    ) {
        if (value != null && value != "") {
            _state.value = _state.value.copy(characterLimit = value.toInt())
            relaunch()
        }
    }

    private fun onTextChange(newText: String) {
        val analysis = TextAnalysisResult.from(newText, _state.value.isBlankSpaceExcluded)

        val limit = _state.value.characterLimit
        val exceeded =
            _state.value.isCharacterLimitEnabled && (limit != null && analysis.characterCount > limit)
        val exceed = if (limit != null) analysis.characterCount - limit else 0

        _state.value = _state.value.copy(
            textToAnalyse = newText,
            characterCount = analysis.characterCount,
            wordCount = analysis.wordCount,
            sentenceCount = analysis.sentenceCount,
            estimatedReadingTime = analysis.estimatedTimeReading,
            isLimitExceeded = exceeded,
            exceed = exceed
        )
    }

    private fun onTextOptionChange(isBlankSpaceExcluded: Boolean) {
        _state.value = _state.value.copy(isBlankSpaceExcluded = isBlankSpaceExcluded)
        relaunch()
    }

    private fun onCharacterLimitEnabledChange(isEnabled: Boolean) {
        if (isEnabled) {
            _state.value = _state.value.copy(isCharacterLimitEnabled = true)
        } else {
            _state.value = _state.value.copy(
                isCharacterLimitEnabled = false,
                characterLimit = null,
                isLimitExceeded = false,
                exceed = 0
            )
        }
    }

    private fun relaunch() {
        onTextChange(_state.value.textToAnalyse)
    }
}