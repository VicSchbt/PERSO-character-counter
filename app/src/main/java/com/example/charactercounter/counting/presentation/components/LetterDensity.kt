package com.example.charactercounter.counting.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.charactercounter.R
import com.example.charactercounter.ui.theme.CharacterCounterTheme
import com.example.charactercounter.ui.theme.Neutral100
import com.example.charactercounter.ui.theme.Purple400

@Composable
fun LetterDensity(
    modifier: Modifier = Modifier,
    letterDensity: Map<Char, Int>,
    totalLetter: Int
) {
    val sortedLetterDensity: List<Map.Entry<Char, Int>> =
        letterDensity.entries.sortedByDescending { it.value }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = stringResource(R.string.letter_density_label),
            style = MaterialTheme.typography.titleSmall)
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            sortedLetterDensity.forEach {
                LetterDensityItem(
                    letter = it.key,
                    letterCount = it.value,
                    totalLetter = totalLetter
                )
            }
        }
    }


}

@SuppressLint("DefaultLocale")
@Composable
fun LetterDensityItem(
    letter: Char,
    letterCount: Int,
    totalLetter: Int
) {
    val percentage = letterCount.toFloat() / totalLetter.toFloat()
    val formattedPercentage = String.format("%.2f", percentage * 100)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = letter.uppercase(),
            modifier = Modifier.width(20.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall
        )
        LinearProgressIndicator(
            progress = {
                percentage
            },
            color = Purple400,
            trackColor =  Neutral100,
            modifier = Modifier.clip(RoundedCornerShape(4.dp))
        )
        Text(text = "$letterCount ($formattedPercentage %)",
            modifier = Modifier.width(80.dp),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelSmall)
    }
}

@Preview(showBackground = true)
@Composable
private fun LetterDensityPreview() {
    CharacterCounterTheme {
        LetterDensity(
            letterDensity = mapOf(Pair('e', 40), Pair('i', 29), Pair('t', 18)),
            totalLetter = 189
        )
    }
}