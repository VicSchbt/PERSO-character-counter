package com.example.charactercounter.counting.presentation

sealed interface CharacterCounterAction {
    data class OnTextChange(val newText: String): CharacterCounterAction
    data class OnIsBlankSpaceExcludedChange(val isExcluded: Boolean): CharacterCounterAction
}