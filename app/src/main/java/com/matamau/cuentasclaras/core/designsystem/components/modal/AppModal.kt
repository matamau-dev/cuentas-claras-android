package com.matamau.cuentasclaras.core.designsystem.components.modal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppElevation
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@ExperimentalMaterial3Api
@Composable
fun AppModal(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    containerColor: Color = AppTheme.colors.background,
    tonalElevation: Dp = AppTheme.elevation.L2,
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        containerColor = containerColor,
        tonalElevation = tonalElevation
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
                .padding(horizontal = AppTheme.spacing.xl)
                .padding(bottom = AppTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.lg
            ),
            content = content,
        )
    }
}