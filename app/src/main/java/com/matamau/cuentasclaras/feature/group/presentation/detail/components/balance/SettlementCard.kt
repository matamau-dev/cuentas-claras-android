package com.matamau.cuentasclaras.feature.group.presentation.detail.components.balance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonOutline
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.components.card.AppElevatedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun BalanceCard(
    fromInitials: String,
    toInitials: String,
    avatarColor: Color,
    avatarTextColor: Color,
    amount: String,
    debtorName: String,
    creditorName: String,
    buttonText: String,
    isPrimaryAction: Boolean,
    onButtonClick: () -> Unit,
) {
    AppElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(AppTheme.spacing.lg)) {
            BalanceParticipants(
                fromInitials = fromInitials,
                toInitials = toInitials,
                amount = amount,
                avatarColor = avatarColor,
                avatarTextColor = avatarTextColor
            )

            Spacer(
                modifier = Modifier.height(AppTheme.spacing.sm),
            )

            BalanceDescription(
                debtorName = debtorName,
                amount = amount,
                creditorName = creditorName,
            )

            Spacer(
                modifier = Modifier.height(AppTheme.spacing.lg),
            )

            if (isPrimaryAction) {
                ButtonPrimary(
                    text = buttonText,
                    onClick = onButtonClick,
                    modifier = Modifier.fillMaxWidth(),
                )
            } else {
                ButtonOutline(
                    text = buttonText,
                    onClick = onButtonClick,
                    modifier = Modifier.fillMaxWidth(),
                )
            }

        }
    }
}