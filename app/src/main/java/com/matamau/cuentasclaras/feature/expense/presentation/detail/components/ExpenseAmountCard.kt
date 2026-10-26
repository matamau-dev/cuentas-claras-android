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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.components.chip.CategoryChip
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ExpenseAmountCard(
    modifier: Modifier = Modifier,
    amount: String,
    category: String,
) {
    AppCard(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = AppTheme.spacing.xl),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Renta mazo",
                style = AppTheme.typography.labelLarge,
                color = AppTheme.colors.onSurfaceVariant,
            )

            Text(
                text = amount,
                style = TextStyle(
                    fontSize = AppTheme.typography.displayLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.onBackground,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CategoryChip(
                    label = category,
                    selected = true
                )

                Text(
                    text = " • ",
                    style = AppTheme.typography.labelLarge,
                    color = AppTheme.colors.onSurfaceVariant,
                )

                Text(
                    text = "Pendiente",
                    style = AppTheme.typography.labelLarge,
                    color = AppTheme.colors.onSurfaceVariant,
                )
            }
        }
    }
}
