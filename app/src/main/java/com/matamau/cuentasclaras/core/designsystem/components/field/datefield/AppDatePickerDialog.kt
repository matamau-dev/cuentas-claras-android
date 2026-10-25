package com.matamau.cuentasclaras.core.designsystem.components.field.datefield

import android.content.res.Configuration
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.matamau.cuentasclaras.core.designsystem.components.field.datefield.util.toLocalDateUtc
import com.matamau.cuentasclaras.core.designsystem.components.field.datefield.util.toUtcMillis
import java.time.LocalDate
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDatePickerDialog(
    initialDate: LocalDate?,
    minDate: LocalDate,
    onDismiss: () -> Unit,
    onConfirm: (LocalDate) -> Unit,
) {
    val spanishLocale = remember { Locale.forLanguageTag("es-MX") }
    val currentConfiguration = LocalConfiguration.current
    val currentContext = LocalContext.current

    val spanishConfiguration = remember(currentConfiguration) {
        Configuration(currentConfiguration).apply { setLocale(spanishLocale) }
    }
    val spanishContext = remember(currentContext, spanishConfiguration) {
        currentContext.createConfigurationContext(spanishConfiguration)
    }

    CompositionLocalProvider(
        LocalConfiguration provides spanishConfiguration,
        LocalContext provides spanishContext,
    ) {
        val selectableDates = remember(minDate) {
            object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean =
                    !utcTimeMillis.toLocalDateUtc().isBefore(minDate)

                override fun isSelectableYear(year: Int): Boolean =
                    year >= minDate.year
            }
        }

        val pickerState = rememberDatePickerState(
            initialSelectedDateMillis = initialDate?.toUtcMillis(),
            yearRange = minDate.year..2100,
            initialDisplayMode = DisplayMode.Picker,
            selectableDates = selectableDates,
        )

        DatePickerDialog (
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(
                    enabled = pickerState.selectedDateMillis != null,
                    onClick = {
                        pickerState.selectedDateMillis?.let { onConfirm(it.toLocalDateUtc()) }
                    },
                ) { Text("Aceptar") }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) { Text("Cancelar") }
            },
        ) {
            DatePicker(state = pickerState, showModeToggle = false)
        }
    }
}