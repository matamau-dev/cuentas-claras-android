package com.matamau.cuentasclaras.feature.group.presentation.detail.components.balance

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun BalanceDescription(
    debtorName: String,
    amount: String,
    creditorName: String,
    modifier:Modifier= Modifier
){
    Row (modifier = modifier) {
        Text(
            text = "$debtorName le debe ",
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onSurface,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "$amount a ",
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onSurfaceVariant,
        )

        Text(
            text = creditorName,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onSurface,
            fontWeight = FontWeight.Bold,
        )
    }
}