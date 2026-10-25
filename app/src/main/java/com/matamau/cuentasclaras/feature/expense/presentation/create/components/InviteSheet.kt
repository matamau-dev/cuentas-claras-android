package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.components.modal.AppModal
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@ExperimentalMaterial3Api
@Composable
fun ExpenseModal(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    containerColor: Color,
    inviteName: String,
    onInviteNameChange: (String) -> Unit,
    inviteEmail: String,
    onInviteEmailChange: (String) -> Unit,
    onSendInvitation: (name: String, email: String) -> Unit,
) {
    AppModal (
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        containerColor = containerColor,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
                .padding(horizontal = AppTheme.spacing.xl)
                .padding(bottom = AppTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.lg),
        ) {
            Text(
                text = "Invitar a un amigo",
                style = AppTheme.typography.headlineSmall,
                color = AppTheme.colors.onBackground,
            )

            InputText(
                value = inviteName,
                onValueChange = onInviteNameChange,
                modifier = Modifier.fillMaxWidth(),
                label = "Nombre",
                placeholder = "Maria",
            )

            InputText(
                value = inviteEmail,
                onValueChange = onInviteEmailChange,
                modifier = Modifier.fillMaxWidth(),
                label = "Correo",
                placeholder = "maria@correo.com",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            ButtonPrimary(
                text = "Enviar invitación",
                onClick = {
                    onSendInvitation(inviteName, inviteEmail)
                    onInviteNameChange("")
                    onInviteEmailChange("")
                    onDismissRequest()
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}