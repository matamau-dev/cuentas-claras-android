package com.matamau.cuentasclaras.feature.login.presentation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.matamau.cuentasclaras.core.designsystem.components.field.InputPassword
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun LoginScreen(
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val focusEmail = remember { FocusRequester() }
    val focusPassword = remember { FocusRequester() }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
    ) {

        InputText(
            value = email,
            onValueChange = { email = it },
            label = "Correo",
            placeholder = "ejemplo@correo.com",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusPassword.requestFocus() }),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusEmail),
        )

        InputPassword(
            value = password,
            onValueChange = { password = it },
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
