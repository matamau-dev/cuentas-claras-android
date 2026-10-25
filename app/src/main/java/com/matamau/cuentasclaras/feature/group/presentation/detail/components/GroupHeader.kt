package com.matamau.cuentasclaras.feature.group.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.components.stack.AvatarStack
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun GroupSummary(
    name: String,
    category: String,
    updatedText: String,
    memberInitials: List<String>,
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.sm),
    ) {
        Text(
            text = name,
            style = AppTheme.typography.headlineSmall,
            color = AppTheme.colors.primary,
        )

        GroupMetaRow(
            category = category,
            updatedText = updatedText,
            memberInitials = memberInitials,
        )
    }
}

@Composable
private fun GroupMetaRow(
    category: String,
    updatedText: String,
    memberInitials: List<String>,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "• ",
                color = AppTheme.colors.primary,
                style = AppTheme.typography.headlineMedium,
            )

            Text(
                text = "$category • $updatedText",
                color = AppTheme.colors.onSurfaceVariant,
                style = AppTheme.typography.labelSmall,
            )
        }

        AvatarStack(
            initials = memberInitials,
            avatarSize = 28.dp,
            overLap = 8.dp,
        )
    }
}