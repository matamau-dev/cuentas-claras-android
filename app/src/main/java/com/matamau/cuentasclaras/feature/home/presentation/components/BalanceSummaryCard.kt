package com.matamau.cuentasclaras.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppColorsSemantic
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun BalanceSummaryCard(
    totalBalance: String,
    groupCount: Int,
    owedToYou: String,
    youOwe: String,
    modifier: Modifier = Modifier,
) {
    AppCard(
        modifier = modifier
            .fillMaxWidth(),
        containerColor = AppTheme.colors.primary,
        contentColor = AppTheme.colors.onPrimary,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.spacing.lg),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.xs,
            ),
        ) {
            Text(
                text = "BALANCE GENERAL",
                style = AppTheme.typography.bodyLarge,
            )

            Text(
                text = totalBalance,
                style = AppTheme.typography.headlineMedium,
            )

            Text(
                text = "$groupCount grupos",
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onPrimary,
            )

            Spacer(
                modifier = Modifier.height(AppTheme.spacing.lg),
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    AppTheme.spacing.md,
                ),
            ) {
                BalanceMiniCard(
                    label = "Te deben",
                    amount = owedToYou,
                    containerColor = AppColorsSemantic.Success,
                    modifier = Modifier.weight(1f),
                )

                BalanceMiniCard(
                    label = "Debes",
                    amount = youOwe,
                    containerColor = AppColorsSemantic.Attention,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun BalanceMiniCard(
    label: String,
    amount: String,
    containerColor: Color,
    modifier: Modifier = Modifier,
) {
    AppOutlinedCard(
        containerColor = containerColor,
        contentColor = AppTheme.colors.onPrimary,
        shape = AppTheme.shapes.medium,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.spacing.md),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = label,
                style = AppTheme.typography.bodyMedium
            )

            Text(
                text = amount,
                style = AppTheme.typography.labelLarge
            )
        }
    }
}