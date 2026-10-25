package com.matamau.cuentasclaras.feature.group.presentation.detail.components.expenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonSecondary
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppColorsSemantic
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun GroupExpenseCard() {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        shape = AppTheme.shapes.extraLarge
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.spacing.lg),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.xs),
            ) {
                Text(
                    text = "TU SALDO EN EL GRUPO",
                    style = AppTheme.typography.labelSmall,
                    color = AppTheme.colors.onSurfaceVariant,
                )

                Text(
                    text = "+$1,240.00",
                    style = AppTheme.typography.headlineLarge,
                    color = AppColorsSemantic.Success,
                )
            }

            ButtonSecondary(
                text = "Liquidar",
                onClick = { println("Liquidar") },
            )
        }
    }
}