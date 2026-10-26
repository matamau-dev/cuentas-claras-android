package com.matamau.cuentasclaras.feature.group.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.expenses.ExpenseList
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.expenses.GroupExpenseCard


@Composable
fun GroupExpensesContent(
    onExpenseDetail: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.lg,
        ),
    ) {
        GroupExpenseCard()

        Text(
            text = "Marzo",
            style = AppTheme.typography.labelLarge,
            color = AppTheme.colors.onSurfaceVariant,
        )

        ExpenseList(onExpenseDetail)
    }
}
