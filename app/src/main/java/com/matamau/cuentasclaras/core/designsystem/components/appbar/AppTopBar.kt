package com.matamau.cuentasclaras.core.designsystem.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(AppTheme.colors.background)
            .padding(AppTheme.spacing.lg),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md),
        content = content,
    )
}
