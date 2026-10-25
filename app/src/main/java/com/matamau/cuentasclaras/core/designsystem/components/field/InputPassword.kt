package com.matamau.cuentasclaras.core.designsystem.components.field

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme

@Composable
fun InputPassword(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    var isVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        isError = isError,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardActions = keyboardActions,
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        label = label?.let { { Text(it, style = AppTheme.typography.bodyMedium) } },
        placeholder = placeholder?.let { { Text(it, style = AppTheme.typography.bodyMedium) } },
        supportingText = supportingText?.let { { Text(it) } },
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(
                    imageVector = if (isVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = if (isVisible) "Ocultar contraseña" else "Mostrar contraseña"
                )
            }
        },
        shape = AppTheme.shapes.medium,
        colors = appOutlinedFieldColors()
    )
}

@Preview(showBackground = true)
@Composable
private fun InputPasswordPreview() {
    CuentasClarasTheme {
        var password by remember { mutableStateOf("") }
        InputPassword(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            placeholder = "••••••••"
        )
    }
}