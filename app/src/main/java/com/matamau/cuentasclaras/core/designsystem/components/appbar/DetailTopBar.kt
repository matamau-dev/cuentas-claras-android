package com.matamau.cuentasclaras.core.designsystem.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun DetailTopBar(
    onBackClick: (() -> Unit)?,
    titleText: String?,
    titleStyle: TextStyle = AppTheme.typography.labelMedium,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.lg),
    ) {
        if (onBackClick != null) {
            CircleIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Atrás",
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.CenterStart),
            )
        }

        if (titleText != null) {
            Text(
                text = titleText,
                style = titleStyle,
                color = AppTheme.colors.onBackground,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}

@Composable
private fun CircleIconButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(AppTheme.colors.surface)
            .border(
                width = 2.dp,
                color = AppTheme.colors.outline,
                shape = CircleShape,
            ),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = AppTheme.colors.primary,
        )
    }
}