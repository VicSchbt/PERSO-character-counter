package com.example.charactercounter.counting.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.charactercounter.R
import com.example.charactercounter.ui.theme.CharacterCounterTheme
import com.example.charactercounter.ui.theme.Orange400
import com.example.charactercounter.ui.theme.Orange500
import com.example.charactercounter.ui.theme.Orange800
import com.example.charactercounter.ui.theme.Purple400
import com.example.charactercounter.ui.theme.Purple500
import com.example.charactercounter.ui.theme.Yellow400
import com.example.charactercounter.ui.theme.Yellow500

@Composable
fun ResultTile(
    value: Int,
    @StringRes labelRes: Int,
    @DrawableRes bgImageRes: Int,
    bgColor: Color,
    bgImageTint: Color
) {
    Row(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(12.dp),
                color = bgColor
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = stringResource(labelRes),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Icon(
            modifier = Modifier.scale(1.3f).offset(x = 30.dp),
            painter = painterResource(bgImageRes),
            contentDescription = null,
            tint = bgImageTint
        )
    }
}

@PreviewLightDark
@Composable
fun ResultTileCharacterPreview() {
    CharacterCounterTheme {
        ResultTile(
            value = 279,
            labelRes = R.string.result_tile_characters,
            bgImageRes = R.drawable.pattern_character_count,
            bgColor = Purple500,
            bgImageTint = Purple400
        )
    }
}

@PreviewLightDark
@Composable
fun ResultTileWordPreview() {
    CharacterCounterTheme {
        ResultTile(
            value = 39,
            labelRes = R.string.result_tile_word,
            bgImageRes = R.drawable.pattern_word_count,
            bgColor = Yellow500,
            bgImageTint = Yellow400
        )
    }
}

@PreviewLightDark
@Composable
fun ResultTileSentencePreview() {
    CharacterCounterTheme {
        ResultTile(
            value = 4,
            labelRes = R.string.result_tile_sentence,
            bgImageRes = R.drawable.pattern_sentence_count,
            bgColor = Orange500,
            bgImageTint = Orange400
        )
    }
}