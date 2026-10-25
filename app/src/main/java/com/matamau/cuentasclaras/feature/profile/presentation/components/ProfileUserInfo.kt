package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ProfileUserInfo(
    name: String,
    email: String,
    onEditProfile: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = name,
            style = AppTheme.typography.labelMedium,
            color = AppTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = email,
            style = AppTheme.typography.labelSmall,
            color = AppTheme.colors.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        TextButton(
            onClick = onEditProfile,
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                text = "Editar perfil",
                style = AppTheme.typography.labelLarge,
                color = AppTheme.colors.secondary,
            )
        }
    }
}
