package com.matamau.cuentasclaras.core.designsystem.components.toggle

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme


@Composable
fun Toggle(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = enabled) {
                onCheckedChange(!checked)
            }
            .padding(
                vertical = AppTheme.spacing.sm,
                horizontal = AppTheme.spacing.md,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.md,
        ),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .widthIn(max = 280.dp),
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.xs,
            ),
        ) {
            Text(
                text = label,
                style = AppTheme.typography.bodyLarge,
                color = if (enabled) {
                    AppTheme.colors.onSurface
                } else {
                    AppTheme.colors.onSurfaceVariant
                },
            )

            if (description != null) {
                Text(
                    text = description,
                    style = AppTheme.typography.bodyMedium,
                    color = AppTheme.colors.onSurfaceVariant,
                )
            }
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = SwitchDefaults.colors(
                checkedThumbColor = AppTheme.colors.onPrimary,
                checkedTrackColor = AppTheme.colors.primary,
                uncheckedThumbColor = AppTheme.colors.onSurfaceVariant,
                uncheckedTrackColor = AppTheme.colors.surface,
                uncheckedBorderColor = AppTheme.colors.outline,
            ),
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun SettingTogglePreview() {
    CuentasClarasTheme {
        Column {
            var notif by remember {
                mutableStateOf(
                    value = true,
                )
            }
            var darkMode by remember {
                mutableStateOf(
                    value = false
                )
            }

            Toggle(
                label = "Notificaciones",
                description = "Recibir alertas de gastos importantes",
                checked = notif,
                onCheckedChange = { notif = it },
            )
            Toggle(
                label = "Modo oscuro",
                checked = darkMode,
                onCheckedChange = { darkMode = it },
            )
        }
    }
}