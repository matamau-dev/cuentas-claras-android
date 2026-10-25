package com.matamau.cuentasclaras.core.designsystem.components.card

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun AppElevatedCard(
    modifier: Modifier = Modifier,
    elevation: Dp = AppTheme.elevation.L2,
    containerColor: Color = AppTheme.colors.surface,
    contentColor: Color = AppTheme.colors.onSurface,
    shape: Shape = AppTheme.shapes.large,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,

    ) {
    val colors = CardDefaults.elevatedCardColors(
        containerColor = containerColor,
        contentColor = contentColor
    )

    val cardElevation = CardDefaults.cardElevation(
        defaultElevation = elevation
    )

    if (onClick != null) {
        ElevatedCard(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = colors,
            elevation = cardElevation,
            content = content,
        )
    } else {

        ElevatedCard(
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.elevatedCardColors(
                containerColor = containerColor,
                contentColor = contentColor,
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = elevation,
            ),
            content = content,
        )
    }
}
