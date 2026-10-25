package com.matamau.cuentasclaras.feature.group.presentation.detail.components.expenses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.components.card.AppElevatedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun ExpenseList() {
    AppElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column {
            ExpenseItem(
                month = "Mar",
                day = "1",
                title = "Renta marzo",
                subtitle = "Pagaste tú • $18,400.00",
                amount = 13800.00,
                splitInfo = "entre 4",
            )

            HorizontalDivider(
                thickness = 1.dp,
                color = AppTheme.colors.outline,
            )

            ExpenseItem(
                month = "Mar",
                day = "1",
                title = "Renta marzo",
                subtitle = "Pagaste tú • $18,400.00",
                amount = 13800.00,
                splitInfo = "entre 4",
            )

            HorizontalDivider(
                thickness = 1.dp,
                color = AppTheme.colors.outline,
            )

            ExpenseItem(
                month = "Feb",
                day = "28",
                title = "Internet + luz",
                subtitle = "Pagó María • $1,620.00",
                amount = -595.10,
                splitInfo = "entre 4",
            )
        }
    }
}