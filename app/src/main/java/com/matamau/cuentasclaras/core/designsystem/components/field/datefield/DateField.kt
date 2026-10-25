package com.matamau.cuentasclaras.core.designsystem.components.field.datefield


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.field.appOutlinedFieldColors
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun DateField(
    value: LocalDate?,
    onValueChange: (LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
    minDate: LocalDate = LocalDate.now(),
) {
    var showPicker by remember { mutableStateOf(false) }

    val formatter = remember {
        DateTimeFormatter.ofPattern("d 'de' MMMM yyyy", Locale.forLanguageTag("es-MX"))
    }

    Box(modifier = modifier) {
        OutlinedTextField(
            value = value?.format(formatter) ?: "",
            onValueChange = {},
            readOnly = true,
            enabled = enabled,
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            label = label?.let { { Text(it, style = AppTheme.typography.bodyMedium) } },
            placeholder = placeholder?.let { { Text(it, style = AppTheme.typography.bodyMedium) } },
            supportingText = supportingText?.let { { Text(it) } },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = "Seleccionar fecha",
                )
            },
            shape = AppTheme.shapes.medium,
            colors = appOutlinedFieldColors(),
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable(
                    enabled = enabled,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) { showPicker = true }
        )
    }

    if (showPicker) {
        AppDatePickerDialog(
            initialDate = value,
            minDate = minDate,
            onDismiss = { showPicker = false },
            onConfirm = {
                onValueChange(it)
                showPicker = false
            },
        )
    }
}