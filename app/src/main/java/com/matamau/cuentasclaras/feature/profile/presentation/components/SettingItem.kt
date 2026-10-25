package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.ui.graphics.vector.ImageVector


data class SettingItem(
    val icon: ImageVector,
    val title: String,
    val detail: String? = null,
    val onClick: () -> Unit = {},
)
