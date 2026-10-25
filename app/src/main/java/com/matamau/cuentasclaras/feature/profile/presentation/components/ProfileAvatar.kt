package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ProfileAvatar(
    initials: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(AppTheme.colors.primary),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = initials,
            style = AppTheme.typography.headlineSmall,
            color = AppTheme.colors.onPrimary,
        )
    }
}
