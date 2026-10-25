package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.components.modal.AppModal
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@ExperimentalMaterial3Api
@Composable
fun PartsSplitModal(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    peopleNames: List<String>,
    onSave: (Map<String, String>) -> Unit,
) {
    var parts by remember(peopleNames) {
        mutableStateOf(
            peopleNames.associateWith { "1" }
        )
    }

    AppModal(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
    ) {
        Text(
            text = "Dividir por partes",
            style = AppTheme.typography.headlineSmall,
            color = AppTheme.colors.onBackground,
        )

        peopleNames.forEach { name ->
            InputText(
                value = parts[name] ?: "1",
                onValueChange = { value ->
                    parts = parts + (name to value)
                },
                modifier = Modifier.fillMaxWidth(),
                label = name,
                placeholder = "Cantidad de partes",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
            )
        }

        ButtonPrimary(
            text = "Guardar distribución",
            onClick = { onSave(parts) },
            modifier = Modifier.fillMaxWidth(),
        )
    }

}