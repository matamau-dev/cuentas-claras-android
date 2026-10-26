package com.matamau.cuentasclaras.feature.expense.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ExpenseInfoCard(
    payer: String,
    expenseDate: String,
    dueDate: String,
    recurrence: String,
    receipt: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.xs,
        ),
    ) {
        Text(
            text = "Información",
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground,
        )

        AppOutlinedCard(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.padding(AppTheme.spacing.lg),
            ) {
                ExpenseInfoRow(
                    label = "Pagó",
                    value = payer,
                )

                ExpenseInfoRow(
                    label = "Fecha del gasto",
                    value = expenseDate,
                )

                ExpenseInfoRow(
                    label = "Fecha límite",
                    value = dueDate,
                )

                ExpenseInfoRow(
                    label = "Se repite",
                    value = recurrence,
                )

                ExpenseInfoRow(
                    label = "Recibo",
                    value = receipt,
                )
            }
        }
    }
}

@Composable
private fun ExpenseInfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.md),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onSurfaceVariant,
        )

        Text(
            text = value,
            style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.onSurface,
        )
    }
}
