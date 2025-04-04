package com.example.charactercounter.counting.presentation

import androidx.lifecycle.ViewModel
import com.example.charactercounter.counting.domain.TextAnalysisResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharacterCounterViewModel: ViewModel() {
    private val _state = MutableStateFlow(CharacterCounterState())
    val state = _state.asStateFlow()

    fun onAction(action: CharacterCounterAction) {
        when(action) {
            is CharacterCounterAction.OnTextChange -> onTextChange(action.newText)
            is CharacterCounterAction.OnIsBlankSpaceExcludedChange -> onTextOptionChange(action.isExcluded)
        }
    }

    private fun onTextChange(newText: String) {
        val analysis = TextAnalysisResult.from(newText, _state.value.isBlankSpaceExcluded)
        _state.value = _state.value.copy(
            textToAnalyse = newText,
            characterCount = analysis.characterCount,
            wordCount = analysis.wordCount,
            sentenceCount = analysis.sentenceCount
        )
    }

    private fun onTextOptionChange(isBlankSpaceExcluded: Boolean) {
        _state.value = _state.value.copy(isBlankSpaceExcluded = isBlankSpaceExcluded)
        onTextChange(_state.value.textToAnalyse)
    }
}