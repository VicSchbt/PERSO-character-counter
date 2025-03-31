package com.example.charactercounter.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.charactercounter.R

val DMSans = FontFamily(
    Font(
        resId = R.font.dm_sans_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.dm_sans_semi_bold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.dm_sans_bold,
        weight = FontWeight.Bold
    )
)

val textPreset1 = TextStyle(
    fontFamily = DMSans,
    fontWeight = FontWeight.Bold,
    fontSize = 40.sp,
    lineHeight = 40.sp,
    letterSpacing = (-1).sp
)

val textPreset2 = TextStyle(
    fontFamily = DMSans,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    letterSpacing = (-1).sp
)

val textPreset3 = TextStyle(
    fontFamily = DMSans,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = (-0.6).sp
)

val textPreset4 = TextStyle(
    fontFamily = DMSans,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    letterSpacing = (-0.6).sp
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)