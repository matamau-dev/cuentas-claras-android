package com.matamau.cuentasclaras.core.designsystem.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.navigation.Routes

@Composable
fun AppBottomBar(
    currentRoute: Routes,
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier,
    onAddClick: (() -> Unit)? = null,
) {
    val buttonSize = 56.dp
    val notchMargin = 6.dp
    val hasAddButton = onAddClick != null
    val barHeight = 72.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(
                barHeight + if (hasAddButton) buttonSize / 2 else 0.dp
            ),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
                .align(Alignment.BottomCenter),
            color = AppTheme.colors.surface,
            shape = if (hasAddButton) {
                NotchedBarShape(
                    notchRadius = buttonSize / 2 + notchMargin
                )
            } else {
                RectangleShape
            },
            shadowElevation = AppTheme.elevation.L1,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = AppTheme.spacing.xl),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center,
                ) {
                    AppBottomBarItem(
                        icon = Icons.Filled.Group,
                        label = "Grupos",
                        selected = currentRoute == Routes.Home,
                        onClick = { onNavigate(Routes.Home) },
                    )
                }

                if (hasAddButton) {
                    Spacer(
                        modifier = Modifier.width(
                            buttonSize + notchMargin * 2
                        )
                    )
                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center,
                ) {
                    AppBottomBarItem(
                        icon = Icons.Filled.Person,
                        label = "Perfil",
                        selected = currentRoute == Routes.Profile,
                        onClick = { onNavigate(Routes.Profile) },
                    )
                }
            }
        }

        if (onAddClick != null) {
            FloatingActionButton(
                onClick = onAddClick,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(buttonSize),
                containerColor = AppTheme.colors.primary,
                contentColor = AppTheme.colors.onPrimary,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = AppTheme.elevation.L2,
                ),
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Agregar gasto",
                )
            }
        }
    }
}

@Composable
private fun AppBottomBarItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val color = if (selected) {
        AppTheme.colors.primary
    } else {
        AppTheme.colors.onSurfaceVariant
    }

    Column(
        modifier = Modifier
            .defaultMinSize(minWidth = 64.dp)
            .clickable(onClick = onClick)
            .padding(
                horizontal = AppTheme.spacing.sm,
                vertical = AppTheme.spacing.xs,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            2.dp
        ),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
        )

        Text(
            text = label,
            style = AppTheme.typography.labelSmall,
            color = color,
            maxLines = 1,
        )
    }
}