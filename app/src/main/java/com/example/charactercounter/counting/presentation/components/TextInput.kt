package com.example.charactercounter.counting.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.charactercounter.R
import com.example.charactercounter.ui.theme.CharacterCounterTheme
import com.example.charactercounter.ui.theme.Neutral100
import com.example.charactercounter.ui.theme.Neutral200
import com.example.charactercounter.ui.theme.Neutral700

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    textValue: String,
    onTextValueChange: (String) -> Unit
) {
    TextField(
        value = textValue,
        onValueChange = { onTextValueChange(it) },
        placeholder = { Text(stringResource(R.string.text_input_placeholder)) },
        textStyle = MaterialTheme.typography.bodyLarge,
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = Neutral700,
            focusedPlaceholderColor = Neutral700,
            unfocusedContainerColor = Neutral100,
            focusedContainerColor = Neutral100
        ),
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(12.dp),
            )
            .border(
                width = 2.dp,
                color = Neutral200,
                shape = RoundedCornerShape(12.dp)
            )
    )
}

@Preview
@Composable
private fun TextInputEmptyPreview() {
    CharacterCounterTheme {
        TextInput(
            modifier = Modifier,
            textValue = "",
            onTextValueChange = {}
        )
    }
}

@Preview
@Composable
private fun TextInputLongTextPreview() {
    CharacterCounterTheme {
        TextInput(
            modifier = Modifier,
            textValue = "Design is the silent ambassador of your brand. Simplicity is key to effective communication, creating clarity in every interaction. A great design transforms complex ideas into elegant solutions, making them easy to understand. It blends aesthetics and functionality seamlessly.",
            onTextValueChange = {}
        )
    }
}