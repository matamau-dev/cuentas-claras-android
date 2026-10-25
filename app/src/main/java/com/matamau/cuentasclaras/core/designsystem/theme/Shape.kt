package com.matamau.cuentasclaras.core.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object AppRadius {
    val sm = 4.dp
    val md = 8.dp
    val lg = 12.dp
    val xl = 16.dp
    val button = 8.dp
}

val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(AppRadius.sm),
    small = RoundedCornerShape(AppRadius.md),
    medium = RoundedCornerShape(AppRadius.lg),
    large = RoundedCornerShape(AppRadius.xl)
)