package com.example.charactercounter.counting.presentation

data class CharacterCounterState(
    val textToAnalyse: String = "",
    val characterCount: Int = 0,
    val wordCount: Int = 0,
    val sentenceCount: Int = 0,
    val estimatedReadingTime: String? = null,
    val isBlankSpaceExcluded: Boolean = true,
    val isCharacterLimitEnabled: Boolean = false,
    val characterLimit: Int? = null,
    val isLimitExceeded: Boolean = false,
    val exceed: Int = 0,
    val letterDensity: Map<Char, Int> = emptyMap(),
    val totalLetter: Int = 0
)