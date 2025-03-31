package com.example.charactercounter.counting.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.charactercounter.R
import com.example.charactercounter.ui.theme.CharacterCounterTheme

@Composable
fun Header(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.logo_light_theme),
            contentDescription = stringResource(R.string.header_logo_description),
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.header_title),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@PreviewLightDark
@Composable
fun HeaderPreview() {
    CharacterCounterTheme {
        Header(modifier = Modifier)
    }
}