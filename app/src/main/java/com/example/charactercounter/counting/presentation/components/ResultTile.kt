package com.example.charactercounter.counting.presentation.components

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.charactercounter.counting.presentation.components.config.ResultTileConfig
import com.example.charactercounter.ui.theme.CharacterCounterTheme

@Composable
fun ResultTile(
    value: Int,
    config: ResultTileConfig
) {
    Row(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(12.dp),
                color = config.bgColor
            )
            .clip(shape = RoundedCornerShape(12.dp)),
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
                text = stringResource(config.labelRes),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Icon(
            modifier = Modifier.scale(1.3f).offset(x = 30.dp),
            painter = painterResource(config.bgImageRes),
            contentDescription = null,
            tint = config.bgImageTint
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResultTileCharacterPreview() {
    CharacterCounterTheme {
        ResultTile(
            value = 279,
            config = ResultTileConfig.CHARACTER
        )
    }
}

@PreviewLightDark
@Composable
fun ResultTileWordPreview() {
    CharacterCounterTheme {
        ResultTile(
            value = 39,
            config = ResultTileConfig.WORD
        )
    }
}

@PreviewLightDark
@Composable
fun ResultTileSentencePreview() {
    CharacterCounterTheme {
        ResultTile(
            value = 4,
            config = ResultTileConfig.SENTENCE
        )
    }
}