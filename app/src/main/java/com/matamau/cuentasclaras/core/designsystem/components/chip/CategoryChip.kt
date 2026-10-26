package com.matamau.cuentasclaras.core.designsystem.components.chip

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme

@Composable
fun CategoryChip(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean,
    onClick: (() -> Unit)? = null,
) {
    FilterChip(
        selected = selected,
        onClick = onClick ?: {},
        modifier = modifier.height(32.dp),
        label = {
            Text(
                text = label,
                style = AppTheme.typography.labelMedium,
            )
        },
        shape = androidx.compose.foundation.shape.RoundedCornerShape(50),
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = selected,
            borderColor = AppTheme.colors.outline,
            selectedBorderColor = AppTheme.colors.primary,
            borderWidth = 1.dp,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = AppTheme.colors.background,
            labelColor = AppTheme.colors.onSurfaceVariant,
            selectedContainerColor = AppTheme.colors.primary,
            selectedLabelColor = AppTheme.colors.onPrimary,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun CategoryChipPreview() {
    CuentasClarasTheme {
        androidx.compose.foundation.layout.Row(
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp),
        ) {
            CategoryChip(label = "Todos", selected = true, onClick = {})
            CategoryChip(label = "Casa", selected = false, onClick = {})
            CategoryChip(label = "Viajes", selected = false, onClick = {})
            CategoryChip(label = "Eventos", selected = false, onClick = {})
        }
    }
}