package com.matamau.cuentasclaras.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.components.card.AppElevatedCard
import com.matamau.cuentasclaras.core.designsystem.components.stack.AvatarStack
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun GroupCard(
    title: String,
    category: String,
    memberCount: Int,
    memberInitials: List<String>,
    balanceLabel: String,
    balanceAmount: String,
    balanceColor: Color,
    onClick: () -> Unit,
) {
    AppElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
    ) {
        Column(
            modifier = Modifier.padding(AppTheme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.sm),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = title,
                    style = AppTheme.typography.labelLarge,
                    color = AppTheme.colors.primary,
                    fontWeight = FontWeight.Bold,
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Más detalles",
                    modifier = Modifier.size(24.dp),
                    tint = AppTheme.colors.onSurface,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "•",
                    color = AppTheme.colors.primary,
                    style = AppTheme.typography.labelMedium,
                )

                Spacer(
                    modifier = Modifier.width(AppTheme.spacing.xs),
                )

                Text(
                    text = "$category • $memberCount personas",
                    color = AppTheme.colors.onSurfaceVariant,
                    style = AppTheme.typography.labelMedium,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AvatarStack(
                    initials = memberInitials,
                    avatarSize = 28.dp,
                )

                Column(
                    horizontalAlignment = Alignment.End,
                ) {
                    Text(
                        text = balanceLabel,
                        style = AppTheme.typography.labelSmall,
                        color = balanceColor.copy(alpha = 0.80f),
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = balanceAmount,
                        style = AppTheme.typography.bodyLarge,
                        color = balanceColor,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}