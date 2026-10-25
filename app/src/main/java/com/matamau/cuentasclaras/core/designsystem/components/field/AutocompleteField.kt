package com.matamau.cuentasclaras.core.designsystem.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutocompleteField(
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
    var expanded by remember { mutableStateOf(value = false) }
    var query by remember(key1 = selected) { mutableStateOf(value = selected?.label ?: "") }

    val filteredOptions = remember(query, options) {
        if (query.isBlank()) {
            options
        } else {
            options.filter { it.label.contains(query, ignoreCase = true) }
        }
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { if (enabled) expanded = it },
        modifier = Modifier
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                expanded = true
            },
            enabled = enabled,
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryEditable, enabled),
            label = label?.let { { Text(it, style = AppTheme.typography.bodyMedium) } },
            placeholder = placeholder?.let { { Text(it, style = AppTheme.typography.bodyMedium) } },
            supportingText = supportingText?.let { { Text(it) } },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            shape = AppTheme.shapes.medium,
            colors = appOutlinedFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded && filteredOptions.isNotEmpty(),
            onDismissRequest = { expanded = false },
        ) {
            filteredOptions.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.label) },
                    onClick = {
                        onSelectedChange(option)
                        query = option.label
                        expanded = false
                    },
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AutocompleteFieldPreview() {
    CuentasClarasTheme {
        val options = listOf(
            SelectOption(id = "1", label = "Alimentación"),
            SelectOption(id = "2", label = "Transporte"),
            SelectOption(id = "3", label = "Salud"),
            SelectOption(id = "4", label = "Entretenimiento"),
        )
        var selected by remember { mutableStateOf<SelectOption?>(null) }

        AutocompleteField(
            options = options,
            selected = selected,
            onSelectedChange = { selected = it },
            label = "Categoría",
            placeholder = "Buscá una categoría",
        )
    }
}