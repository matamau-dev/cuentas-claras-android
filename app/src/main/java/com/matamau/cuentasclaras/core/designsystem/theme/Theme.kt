package com.matamau.cuentasclaras.core.designsystem.theme

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = AppColorsLight.Primary,
    onPrimary = AppColorsLight.OnPrimary,
    background = AppColorsLight.CanvasAlt,
    surface = AppColorsLight.Canvas,
    onSurface = AppColorsLight.Ink,
    onSurfaceVariant = AppColorsLight.Muted,
    outline = AppColorsLight.Hairline,
    onTertiary = AppColorsLight.SurfaceTealMid,
    secondary = AppColorsLight.Accent2,
    tertiary = AppColorsLight.SurfaceVioletSoft,
    error = AppColorsSemantic.Critical,
    onError = AppColorsLight.OnPrimary,
)

// 1. Color schemes
private val DarkColorScheme = darkColorScheme(
    primary = AppColorsDark.Primary,
    onPrimary = AppColorsDark.OnPrimary,
    background = AppColorsDark.Canvas,
    surface = AppColorsDark.CanvasAlt,
    onSurface = AppColorsDark.Ink,
    onSurfaceVariant = AppColorsDark.Muted,
    outline = AppColorsDark.Hairline,
    secondary = AppColorsDark.Accent2,
    onTertiary = AppColorsDark.SurfaceTealMid,
    error = AppColorsSemantic.Critical,
    onError = AppColorsDark.OnPrimary
)

val AppMaterialTypography = Typography(
    displayLarge = AppTypography.displayXxl,
    displayMedium = AppTypography.displayLg,
    displaySmall = AppTypography.displayMd,
    headlineLarge = AppTypography.headingLg,
    headlineMedium = AppTypography.headingLg,
    headlineSmall = AppTypography.headingLg,
    titleLarge = AppTypography.headingLg,
    titleMedium = AppTypography.bodyLg,
    titleSmall = AppTypography.bodyMd,
    bodyLarge = AppTypography.bodyLg,
    bodyMedium = AppTypography.bodyMd,
    bodySmall = AppTypography.caption,
    labelLarge = AppTypography.buttonMd,
    labelMedium = AppTypography.caption,
    labelSmall = AppTypography.microCap,


)

// 2. CompositionLocals
private val LocalAppSpacing = staticCompositionLocalOf { AppSpacing }
private val LocalAppElevation = staticCompositionLocalOf { AppElevation }
private val LocalAppRadius = staticCompositionLocalOf { AppRadius }

// 3. Punto de acceso único
object AppTheme {
    val colors: androidx.compose.material3.ColorScheme
        @Composable get() = MaterialTheme.colorScheme

    val typography: androidx.compose.material3.Typography
        @Composable get() = MaterialTheme.typography

    val shapes: androidx.compose.material3.Shapes
        @Composable get() = MaterialTheme.shapes

    val spacing: AppSpacing
        @Composable get() = LocalAppSpacing.current

    val elevation: AppElevation
        @Composable get() = LocalAppElevation.current

    val radius: AppRadius
        @Composable get() = LocalAppRadius.current
}

private tailrec fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Composable
fun CuentasClarasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context.findActivity())?.window
            if (window != null) {
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                    !darkTheme
            }
        }
    }

    CompositionLocalProvider(
        LocalAppSpacing provides AppSpacing,
        LocalAppElevation provides AppElevation,
        LocalAppRadius provides AppRadius
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppMaterialTypography,
            shapes = AppShapes,
            content = content
        )
    }
}