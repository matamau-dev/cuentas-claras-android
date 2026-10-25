package com.matamau.cuentasclaras.core.designsystem.component.field

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.matamau.cuentasclaras.core.designsystem.components.field.SelectOption
import com.matamau.cuentasclaras.core.designsystem.components.field.appOutlinedFieldColors
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectField(
    options: List<SelectOption>,
    selected: SelectOption?,
    onSelectedChange: (SelectOption) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selected?.label ?: "Selecciona una Opcion",
            onValueChange = {},
            readOnly = true,
            enabled = enabled,
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(
                    ExposedDropdownMenuAnchorType.PrimaryNotEditable,
                    enabled
                ),
            label = label?.let {
                {
                    Text(
                        it,
                        style = AppTheme.typography.bodyMedium
                    )
                }
            },
            placeholder = placeholder?.let {
                {
                    Text(
                        it,
                        style = AppTheme.typography.bodyMedium
                    )
                }
            },
            supportingText = supportingText?.let { { Text(it) } },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            shape = AppTheme.shapes.medium,
            colors = appOutlinedFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(option.label)
                    },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SelectFieldPreview() {
    CuentasClarasTheme {
        val options = listOf(
            SelectOption(id = "cash", label = "Efectivo"),
            SelectOption(id = "card", label = "Tarjeta"),
            SelectOption(id = "transfer", label = "Transferencia"),
        )
        var selected by remember { mutableStateOf<SelectOption?>(null) }

        SelectField(
            options = options,
            selected = selected,
            onSelectedChange = { selected = it },
            label = "Método de pago",
            placeholder = "Seleccioná una opción",
        )
    }
}