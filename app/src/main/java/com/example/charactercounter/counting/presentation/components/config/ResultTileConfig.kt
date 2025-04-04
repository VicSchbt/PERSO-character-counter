package com.example.charactercounter.counting.presentation.components.config

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.charactercounter.R
import com.example.charactercounter.ui.theme.Orange400
import com.example.charactercounter.ui.theme.Orange500
import com.example.charactercounter.ui.theme.Purple400
import com.example.charactercounter.ui.theme.Purple500
import com.example.charactercounter.ui.theme.Yellow400
import com.example.charactercounter.ui.theme.Yellow500

enum class ResultTileConfig(
    @StringRes val labelRes: Int,
    @DrawableRes val bgImageRes: Int,
    val bgColor: Color,
    val bgImageTint: Color
) {
    CHARACTER(
        labelRes = R.string.result_tile_characters,
        bgImageRes = R.drawable.pattern_character_count,
        bgColor = Purple500,
        bgImageTint = Purple400
    ),
    WORD(
        labelRes = R.string.result_tile_word,
        bgImageRes = R.drawable.pattern_word_count,
        bgColor = Yellow500,
        bgImageTint = Yellow400
    ),
    SENTENCE(
        labelRes = R.string.result_tile_sentence,
        bgImageRes = R.drawable.pattern_sentence_count,
        bgColor = Orange500,
        bgImageTint = Orange400
    )
}