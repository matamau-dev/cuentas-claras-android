package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.card.AppElevatedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.common.AmountInput

@Composable
fun ExpenseAmountSection(
    amount: String,
    onAmountChange: (String) -> Unit
) {
    AppElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = AppTheme.shapes.extraLarge
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = AppTheme.spacing.xl)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = AppTheme.spacing.xl),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "MONTO TOTAL",
                    style = AppTheme.typography.labelSmall,
                    color = AppTheme.colors.onSurfaceVariant,
                )

                AmountInput(
                    value = amount,
                    onValueChange = onAmountChange,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = "$0.00",
                )

                Text(
                    text = "MXN",
                    style = AppTheme.typography.labelMedium,
                    color = AppTheme.colors.onSurfaceVariant,
                )
            }
        }
    }
}