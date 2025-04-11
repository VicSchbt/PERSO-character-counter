package com.example.charactercounter.counting.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.charactercounter.R
import com.example.charactercounter.ui.theme.CharacterCounterTheme
import com.example.charactercounter.ui.theme.Neutral0
import com.example.charactercounter.ui.theme.Neutral900
import com.example.charactercounter.ui.theme.Purple400

@Composable
fun TextOptions(
    modifier: Modifier = Modifier,
    isBlankSpaceExcluded: Boolean = true,
    onIsBlankSpaceExcludedChange: (Boolean) -> Unit,
    isCharacterLimitEnabled: Boolean,
    onCharacterLimitEnabledChange: (Boolean) -> Unit,
    characterLimit: String,
    onCharacterLimitChange: (String) -> Unit,
) {
    LabelledCheckbox(
        label = stringResource(R.string.text_input_exclude_spaces),
        checked = isBlankSpaceExcluded,
        onCheckedChange = { onIsBlankSpaceExcludedChange(it) },
        modifier = modifier
    )
    LabelledCheckboxWithTextField(
        label = stringResource(R.string.text_input_character_limit),
        checked = isCharacterLimitEnabled,
        onCheckedChange = onCharacterLimitEnabledChange,
        textValue = characterLimit,
        onTextValueChange = onCharacterLimitChange,
        modifier = modifier
    )

}

@Composable
fun LabelledCheckbox(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    CheckboxRowContent(modifier, checked, onCheckedChange, label)
}

@Composable
fun LabelledCheckboxWithTextField(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    textValue: String,
    onTextValueChange: (String) -> Unit
) {
    CheckboxRowContent(
        modifier = modifier,
        label = label,
        checked = checked,
        onCheckedChange = onCheckedChange,
        trailingContent = {
            if (checked) {
                Spacer(modifier = Modifier.width(10.dp))
                BasicTextField(
                    value = textValue,
                    onValueChange = onTextValueChange,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.height(30.dp).requiredWidth(55.dp).border(
                        width = 1.dp,
                        color = Neutral900,
                        shape = RoundedCornerShape(4.dp)
                    ),
                    textStyle = MaterialTheme.typography.labelSmall,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            innerTextField()
                        }
                    }
                )
            }
        }
    )
}

@Composable
private fun CheckboxRowContent(
    modifier: Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    trailingContent : @Composable (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .selectable(
                selected = checked,
                onClick = { onCheckedChange(!checked) },
                role = Role.Checkbox
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .size(16.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(if (checked) Purple400 else Neutral0)
                .clickable { onCheckedChange(!checked) }
                .border(
                    width = 1.dp,
                    color = if (checked) Purple400 else Neutral900,
                    shape = RoundedCornerShape(4.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                Icon(
                    painter = painterResource(R.drawable.icon_check), // ← any icon!
                    contentDescription = "Checked",
                    tint = Neutral900,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall
        )
        trailingContent?.invoke()
    }
}


@Preview(showBackground = true)
@Composable
private fun TextOptionsPreview() {
    CharacterCounterTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextOptions(
                isBlankSpaceExcluded = false,
                onIsBlankSpaceExcludedChange = {},
                isCharacterLimitEnabled = true,
                onCharacterLimitEnabledChange = {},
                characterLimit = "350",
                onCharacterLimitChange = {}
            )
        }

    }
}