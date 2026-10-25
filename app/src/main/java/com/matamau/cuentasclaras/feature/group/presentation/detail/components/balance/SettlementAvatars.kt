package com.matamau.cuentasclaras.feature.group.presentation.detail.components.balance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.AvatarCircle


@Composable
fun BalanceParticipants(
    fromInitials: String,
    toInitials: String,
    amount: String,
    avatarColor: Color,
    avatarTextColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AvatarCircle(
                initials = fromInitials,
                backgroundColor = avatarColor,
                textColor = avatarTextColor
            )

            Spacer(
                modifier = Modifier.width(AppTheme.spacing.sm),
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt,
                tint = AppTheme.colors.onSurfaceVariant,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
            )

            Spacer(
                modifier = Modifier.width(AppTheme.spacing.sm),
            )
            AvatarCircle(
                initials = toInitials,
                backgroundColor = avatarColor,
                textColor = avatarTextColor,
            )
        }
        Text(
            text = amount,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )
    }
}