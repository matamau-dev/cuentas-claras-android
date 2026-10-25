package com.matamau.cuentasclaras.feature.expense.presentation.create.components.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun AmountInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "$0.00"
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = TextStyle(
            fontSize = AppTheme.typography.displayLarge.fontSize,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.onBackground,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        singleLine = true,
        cursorBrush = SolidColor(AppTheme.colors.primary),
        decorationBox = { innerTextField ->
            if (value.isEmpty()) {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        fontSize = AppTheme.typography.displayLarge.fontSize,
                        fontWeight = FontWeight.Bold,
                        color = AppTheme.colors.onBackground.copy(alpha = 0.3f),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            innerTextField()
        }
    )
}