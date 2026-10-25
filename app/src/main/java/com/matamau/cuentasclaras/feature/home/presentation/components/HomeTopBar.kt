package com.matamau.cuentasclaras.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun HomeTopBar(
    userName: String,
    notificationCount: Int
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Buenos dias!",
            style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.onSurface,
        )

        NotificationButton(notificationCount)
    }
    Text(
        text = "$userName",
        style = AppTheme.typography.headlineLarge,
        color = AppTheme.colors.onSurface,
    )
}

@Composable
private fun NotificationButton(
    notificationCount: Int
) {
    Box(
        modifier = Modifier.size(40.dp),
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Notificaciones",
            tint = AppTheme.colors.onSurface,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.Center),
        )

        if (notificationCount > 0) {
            NotificationBadge(notificationCount)
        }
    }
}

@Composable
private fun NotificationBadge(
    notificationCount: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .defaultMinSize(minWidth = 16.dp)
            .height(16.dp)
            .background(color = AppTheme.colors.error, shape = CircleShape)
            .padding(horizontal = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = if (notificationCount > 99) "99+" else notificationCount.toString(),
            style = AppTheme.typography.labelSmall,
            color = AppTheme.colors.onError,
        )
    }
}