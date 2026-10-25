package com.matamau.cuentasclaras.core.designsystem.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun AppOutlinedCard(
    modifier: Modifier = Modifier,
    containerColor: Color = AppTheme.colors.surface,
    contentColor: Color = AppTheme.colors.onSurface,
    shape: Shape = AppTheme.shapes.large,
    border: BorderStroke = BorderStroke(
        1.dp,
        AppTheme.colors.outline,
    ),
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = CardDefaults.outlinedCardColors(
        containerColor = containerColor,
        contentColor = contentColor
    )

    if (onClick != null) {
        OutlinedCard(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            border = border,
            colors = CardDefaults.outlinedCardColors(
                containerColor = containerColor,
                contentColor = contentColor,
            ),
            content = content,
        )
    } else {
        OutlinedCard(
            modifier = modifier,
            shape = shape,
            border = border,
            colors = CardDefaults.outlinedCardColors(
                containerColor = containerColor,
                contentColor = contentColor,
            ),
            content = content,
        )
    }
}
