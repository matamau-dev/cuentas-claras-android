package com.matamau.cuentasclaras.core.designsystem.components.field

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

data class SelectOption(
    val id: String,
    val label: String
)

@Composable
internal fun appOutlinedFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedContainerColor = AppTheme.colors.background,
    unfocusedContainerColor = AppTheme.colors.background,
    focusedBorderColor = AppTheme.colors.primary,
    unfocusedBorderColor = AppTheme.colors.outline,
    errorBorderColor = AppTheme.colors.error,
    cursorColor = AppTheme.colors.primary,
    focusedLabelColor = AppTheme.colors.primary,
    unfocusedLabelColor = AppTheme.colors.onSurfaceVariant,
)