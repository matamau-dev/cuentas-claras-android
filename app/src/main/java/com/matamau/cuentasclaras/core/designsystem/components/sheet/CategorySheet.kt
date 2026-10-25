package com.matamau.cuentasclaras.core.designsystem.components.sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategorySheet(
    title: String,
    placeholder: String,
    existing: List<String>,
    onSave: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    var name by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val trimmed = name.trim()
    val isDuplicate = existing.any { it.equals(trimmed, ignoreCase = true) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = AppTheme.colors.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
                .padding(horizontal = AppTheme.spacing.xl)
                .padding(bottom = AppTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.lg),
        ) {
            Text(
                text = title,
                style = AppTheme.typography.headlineSmall,
                color = AppTheme.colors.onBackground,
            )
            InputText(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                label = "Nombre",
                placeholder = placeholder,
                isError = isDuplicate,
                supportingText = if (isDuplicate) "Ya existe con ese nombre" else null,
            )
            ButtonPrimary(
                text = "Guardar",
                onClick = { onSave(trimmed) },
                enabled = trimmed.isNotEmpty() && !isDuplicate,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}