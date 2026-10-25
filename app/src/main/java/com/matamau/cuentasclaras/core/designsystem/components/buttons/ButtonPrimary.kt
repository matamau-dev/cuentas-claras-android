package com.matamau.cuentasclaras.core.designsystem.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme

@Composable
fun ButtonPrimary(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = AppTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.primary, contentColor = AppTheme.colors.onPrimary,
            disabledContainerColor = AppTheme.colors.primary.copy(alpha = 0.38f),
            disabledContentColor = AppTheme.colors.onPrimary.copy(alpha = 0.38f)
        ), contentPadding = PaddingValues(
            horizontal = AppTheme.spacing.lg,
            vertical = AppTheme.spacing.md
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = AppTheme.elevation.L1
        )
    ) {
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
            )
            Spacer(modifier = Modifier.width(AppTheme.spacing.xs))
        }

        Text(
            text = text,
            style = AppTheme.typography.labelLarge
        )

        if (trailingIcon != null) {
            Spacer(modifier = Modifier.width(AppTheme.spacing.xs))
            Icon(
                imageVector = trailingIcon,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewButtonPrimary() {
    CuentasClarasTheme() {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            ButtonPrimary(text = "Continuar", onClick = {})
            ButtonPrimary(text = "Deshabilitado", onClick = {}, enabled = false)
        }
    }
}