package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ProfileStatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor = AppTheme.colors.surface,
            contentColor = AppTheme.colors.onSurface,
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = AppTheme.elevation.L1,
        ),
        shape = AppTheme.shapes.extraLarge,
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = AppTheme.spacing.md,
                    horizontal = AppTheme.spacing.sm,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = value,
                style = AppTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.onSurface,
                maxLines = 1,
            )

            Text(
                text = label,
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onSurfaceVariant,
                maxLines = 1,
            )
        }
    }
}
