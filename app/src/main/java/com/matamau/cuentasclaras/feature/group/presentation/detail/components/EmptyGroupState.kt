package com.matamau.cuentasclaras.feature.group.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun EmptyExpensesState(
    onAddExpense: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppTheme.spacing.xxl),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.md,
        ),
    ) {
        Icon(
            imageVector = Icons.Outlined.Receipt,
            contentDescription = null,
            tint = AppTheme.colors.onSurfaceVariant,
            modifier = Modifier.size(48.dp),
        )

        Text(
            text = "Aún no hay gastos",
            style = AppTheme.typography.labelLarge,
            color = AppTheme.colors.onSurface,
        )

        Text(
            text = "Agregá el primero para empezar a dividir cuentas.",
            style = AppTheme.typography.labelMedium,
            color = AppTheme.colors.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )

        ButtonPrimary(
            text = "Agregar el primer gasto",
            onClick = onAddExpense,
            leadingIcon = Icons.Filled.Add,
        )
    }
}
