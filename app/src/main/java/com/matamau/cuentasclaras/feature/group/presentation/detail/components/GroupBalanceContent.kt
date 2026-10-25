package com.matamau.cuentasclaras.feature.group.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.balance.BalanceCard


@Composable
fun GroupBalanceContent() {
    Column(
        modifier = Modifier.padding(
            all = AppTheme.spacing.lg,
        ),
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.xl,
        ),
    ) {
        BalanceCard(
            fromInitials = "JL",
            toInitials = "MR",
            avatarColor = AppTheme.colors.tertiary,
            avatarTextColor = AppTheme.colors.onSurface,
            amount = "$780.00",
            debtorName = "Julio",
            creditorName = "Maria",
            buttonText = "Recordar pago",
            isPrimaryAction = false,
            onButtonClick = {
                println("Recordar pago")
            },
        )

        BalanceCard(
            fromInitials = "MC",
            toInitials = "JT",
            avatarColor = AppTheme.colors.tertiary,
            avatarTextColor = AppTheme.colors.onSurface,
            amount = "$780.00",
            debtorName = "Marco",
            creditorName = "Janet",
            buttonText = "Recordar pago",
            isPrimaryAction = false,
            onButtonClick = { println("Recordar pago") }
        )
    }
}
