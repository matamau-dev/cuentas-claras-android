package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ProfileSettingItem(
    item: SettingItem,
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clickable { item.onClick() }
            .padding(
                horizontal = AppTheme.spacing.lg,
                vertical = AppTheme.spacing.md,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.md,
        ),
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = null,
            tint = AppTheme.colors.onSurfaceVariant,
        )

        Text(
            text = item.title,
            style = AppTheme.typography.labelLarge,
            color = AppTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f),
        )

        item.detail?.let { detail ->
            Text(
                text = detail,
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onSurfaceVariant,
                maxLines = 1,
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = AppTheme.colors.onSurfaceVariant,
        )
    }
}
