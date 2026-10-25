package com.matamau.cuentasclaras.feature.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.navigation.Routes

@Composable
fun HomeBottomBar(
    currentRoute: Routes,
    onNavigate: (Routes) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppTheme.spacing.xl),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HomeBottomBarItem(
            icon = Icons.Filled.Group,
            label = "Grupos",
            selected = currentRoute == Routes.Home,
            onClick = { onNavigate(Routes.Home) }
        )

        HomeBottomBarItem(
            icon = Icons.Filled.Person,
            label = "Perfil",
            selected = currentRoute == Routes.Profile,
            onClick = { onNavigate(Routes.Profile) },
        )
    }
}

@Composable
private fun HomeBottomBarItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val color = if (selected) AppTheme.colors.primary else AppTheme.colors.onSurfaceVariant

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ) { onClick() }
            .padding(AppTheme.spacing.xs),
    ) {
        Icon(imageVector = icon, contentDescription = label, tint = color)
        Text(text = label, style = AppTheme.typography.labelSmall, color = color)
    }
}