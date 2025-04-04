package com.example.charactercounter.counting.presentation

sealed interface CharacterCounterAction {
    data class OnTextChange(val newText: String): CharacterCounterAction
}