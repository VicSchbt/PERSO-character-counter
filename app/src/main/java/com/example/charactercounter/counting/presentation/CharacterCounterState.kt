package com.example.charactercounter.counting.presentation

data class CharacterCounterState(
    val textToAnalyse: String = "",
    val characterCount: Int = 0,
    val wordCount: Int = 0,
    val sentenceCount: Int = 0,
    val isBlankSpaceExcluded: Boolean = true
)