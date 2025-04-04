package com.example.charactercounter.counting.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
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
    onIsBlankSpaceExcludedChange: (Boolean) -> Unit
) {
    LabelledCheckbox(
        label = stringResource(R.string.text_input_exclude_spaces),
        checked = isBlankSpaceExcluded,
        onCheckedChange = { onIsBlankSpaceExcludedChange(it) }
    )
}

@Composable
fun LabelledCheckbox(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
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
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun TextOptionsPreview() {
    CharacterCounterTheme {
        TextOptions(
            isBlankSpaceExcluded = false,
            onIsBlankSpaceExcludedChange = {}
        )
    }
}