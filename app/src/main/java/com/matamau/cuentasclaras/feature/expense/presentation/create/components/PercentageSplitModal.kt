package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonOutline
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.components.modal.AppModal
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PercentageSplitModal(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    peopleNames: List<String>,
    onSave: (Map<String, Int>) -> Unit,
) {
    var percentages by remember(peopleNames) {
        mutableStateOf(
            peopleNames.associateWith { "100" }
        )
    }

    val totalPercentage = percentages.values.sumOf {
        it.toIntOrNull() ?: 0
    }


    AppModal(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
    ) {
        Text(
            text = "Dividir por porcentaje",
            style = AppTheme.typography.headlineSmall,
            color = AppTheme.colors.onBackground,
        )

        peopleNames.forEach { name ->
            InputText(
                value = percentages[name] ?: "",
                onValueChange = { input ->
                    if (input.isEmpty() ||
                        (input.all { it.isDigit() } &&
                                input.toIntOrNull() in 0..100)
                    ) {
                        percentages = percentages + (name to input)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                label = name,
                placeholder = "0 - 100",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
                trailingIcon = {
                    Text(
                        text = "%",
                        style = AppTheme.typography.bodyLarge,
                        color = AppTheme.colors.onBackground,
                    )
                },
            )
        }

        Text(
            text = "Total asignado: $totalPercentage%",
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onBackground,
        )

        if (totalPercentage != 100) {
            Text(
                text = "Los porcentajes deben sumar 100%.",
                style = AppTheme.typography.bodySmall,
                color = AppTheme.colors.error,
            )
        }

        ButtonPrimary(
            text = "Guardar distribución",
            onClick = {
                onSave(
                    percentages.mapValues { (_, value) ->
                        value.toInt()
                    }
                )

            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}