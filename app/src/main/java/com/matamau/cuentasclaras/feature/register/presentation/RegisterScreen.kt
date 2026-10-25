package com.matamau.cuentasclaras.feature.register.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.matamau.cuentasclaras.core.designsystem.components.field.InputPassword
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun RegisterScreen(
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var names by remember { mutableStateOf(value = "") }
    var phone by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val focusNames = remember { FocusRequester() }
    val focusPhones = remember { FocusRequester() }
    val focusEmail = remember { FocusRequester() }
    val focusPassword = remember { FocusRequester() }


    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
    ) {
        Text(
            text = "Bienvenido",
            style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.onSurface,
            textAlign = TextAlign.Center
        )

        InputText(
            value = names,
            onValueChange = { println("Esto es name: {$it}") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusPhones.requestFocus() }),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusNames),
            label = "Nombre completo:",
            placeholder = "Mauricio "
        )

        InputText(
            value = phone,
            onValueChange = { println("Esto es phone: {$it}") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusEmail.requestFocus() }),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusPhones),
            label = "Telefono:",
            placeholder = "9616923377"
        )

        InputText(
            value = email,
            onValueChange = { println("XD ${it}") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusPassword.requestFocus() }),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusEmail),
            label = "Correo:",
            placeholder = "Ejemplo@correo.com"
        )

        InputPassword(
            value = password,
            onValueChange = { println("") },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusPassword),
            label = "Contraseña",
            keyboardActions = KeyboardActions(
                onDone = {
                    onSubmit
                }),
        )
    }
}
