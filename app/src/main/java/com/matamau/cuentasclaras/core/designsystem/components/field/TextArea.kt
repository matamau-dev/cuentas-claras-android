package com.matamau.cuentasclaras.core.designsystem.components.field

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme

@Composable
fun TextArea(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
    minLines: Int = 3,
    maxLines: Int = 6,
) {
    InputText(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 96.dp),
        label = label,
        placeholder = placeholder,
        enabled = enabled,
        isError = isError,
        supportingText = supportingText,
        singleLine = false,
        minLines = minLines,
        maxLines = maxLines,
    )
}

@Preview(showBackground = true)
@Composable
private fun TextAreaPreview() {
    CuentasClarasTheme {
        var text by remember { mutableStateOf("") }
        TextArea(
            value = text,
            onValueChange = { text = it },
            label = "Descripción",
            placeholder = "Escribí una nota sobre este gasto..."
        )
    }
}