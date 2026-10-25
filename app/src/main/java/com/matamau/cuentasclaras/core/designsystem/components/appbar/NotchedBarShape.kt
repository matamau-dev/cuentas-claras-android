package com.matamau.cuentasclaras.core.designsystem.components.appbar

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

class NotchedBarShape(
    private val notchRadius: Dp,
) : Shape {
    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: androidx.compose.ui.unit.LayoutDirection,
        density: Density
    ): Outline {
        val radius = with(density) { notchRadius.toPx() }
        val centerX = size.width / 2f

        val bar = Path().apply { addRect(Rect(0f, 0f, size.width, size.height)) }
        val notch = Path().apply {
            addOval(Rect(centerX - radius, -radius, centerX + radius, radius))
        }

        return Outline.Generic(Path.combine(PathOperation.Difference, bar, notch))
    }

}