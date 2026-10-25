package com.matamau.cuentasclaras.core.designsystem.components.card

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    elevation: Dp = AppTheme.elevation.L1,
    containerColor: Color = AppTheme.colors.surface,
    contentColor: Color = AppTheme.colors.onSurface,
    shape: Shape = AppTheme.shapes.large,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = CardDefaults.cardColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )

    val cardElevation = CardDefaults.cardElevation(
        defaultElevation = elevation,
    )

    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = colors,
            elevation = cardElevation,
            content = content,
        )
    } else {
        Card(
            modifier = modifier,
            shape = shape,
            colors = colors,
            elevation = cardElevation,
            content = content,
        )
    }
}
