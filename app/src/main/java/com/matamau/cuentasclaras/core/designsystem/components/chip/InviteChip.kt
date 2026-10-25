package com.matamau.cuentasclaras.core.designsystem.components.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun InviteChip(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Invitar"
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(AppTheme.colors.surface)
            .border(
                width = 1.dp,
                color = AppTheme.colors.outline,
                shape = RoundedCornerShape(50),
            )
            .clickable(
                indication = null,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                onClick = onClick,
            )
            .padding(
                horizontal = AppTheme.spacing.md,
                vertical = 4.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(
                    AppTheme.colors.onSurfaceVariant.copy(
                        alpha = 0.15f,
                    ),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = AppTheme.colors.onSurfaceVariant,
                modifier = Modifier.size(14.dp),
            )
        }

        Spacer(
            modifier = Modifier.width(AppTheme.spacing.xs),
        )

        Text(
            text = label,
            style = AppTheme.typography.labelMedium,
            color = AppTheme.colors.onSurfaceVariant,
        )
    }
}