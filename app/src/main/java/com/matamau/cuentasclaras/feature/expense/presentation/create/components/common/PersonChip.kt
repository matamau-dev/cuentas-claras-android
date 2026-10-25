package com.matamau.cuentasclaras.feature.expense.presentation.create.components.common

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun PersonChip(
    initials: String,
    name: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(
                color =
                    if (selected) AppTheme.colors.primary
                    else AppTheme.colors.surface
            )
            .border(
                width = 1.dp,
                color = if (selected) AppTheme.colors.primary else AppTheme.colors.outline,
                shape = RoundedCornerShape(50)
            )
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ) { onClick() }
            .padding(start = 4.dp, end = AppTheme.spacing.md, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(
                    color =
                        if (selected) AppTheme.colors.onPrimary.copy(alpha = 0.2f)
                        else AppTheme.colors.primary
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = initials,
                style = AppTheme.typography.labelSmall,
                color = if (selected) AppTheme.colors.onPrimary else AppTheme.colors.onPrimary,
            )
        }

        Spacer(modifier = Modifier.width(AppTheme.spacing.xs))

        Text(
            text = name,
            style = AppTheme.typography.labelMedium,
            color = if (selected) AppTheme.colors.onPrimary else AppTheme.colors.onSurface,
        )
    }
}