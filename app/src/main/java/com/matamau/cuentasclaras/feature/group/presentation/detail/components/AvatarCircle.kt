package com.matamau.cuentasclaras.feature.group.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun AvatarCircle(
    initials: String,
    backgroundColor: Color,
    textColor: Color,
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .border(width = 2.dp, color = AppTheme.colors.surface, shape = CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = initials,
            style = AppTheme.typography.labelSmall,
            color = textColor,
            fontWeight = FontWeight.Bold,
        )
    }
}