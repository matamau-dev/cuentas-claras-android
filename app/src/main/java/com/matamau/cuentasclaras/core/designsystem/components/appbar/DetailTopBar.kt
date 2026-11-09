package com.matamau.cuentasclaras.core.designsystem.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

data class DetailTopBarMenuItem(
    val title: String,
    val icon: ImageVector? = null,
    val isDestructive: Boolean = false,
    val onClick: () -> Unit,
)

@Composable
fun DetailTopBar(
    onBackClick: (() -> Unit)?,
    titleText: String?,
    titleStyle: TextStyle = AppTheme.typography.labelMedium,
    menuItems: List<DetailTopBarMenuItem> = emptyList()
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.lg),
    ) {
        if (onBackClick != null) {
            CircleIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Atrás",
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.CenterStart),
            )
        }

        if (titleText != null) {
            Text(
                text = titleText,
                style = titleStyle,
                color = AppTheme.colors.onBackground,
                modifier = Modifier.align(Alignment.Center),
            )
        }

        if (menuItems.isNotEmpty()) {
            Box(
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                IconButton(
                    onClick = { expanded = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Más opciones",
                        tint = AppTheme.colors.onBackground,
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    menuItems.forEach { item ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = item.title,
                                    color = if (item.isDestructive) {
                                        AppTheme.colors.error
                                    } else {
                                        AppTheme.colors.onSurface
                                    },
                                )
                            },
                            leadingIcon = item.icon?.let {
                                {
                                    Icon(
                                        imageVector = it,
                                        contentDescription = null,
                                        tint = if (item.isDestructive) {
                                            AppTheme.colors.error
                                        } else {
                                            AppTheme.colors.onSurfaceVariant
                                        },
                                    )
                                }
                            },
                            onClick = {
                                expanded = false
                                item.onClick()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CircleIconButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(AppTheme.colors.surface)
            .border(
                width = 2.dp,
                color = AppTheme.colors.outline,
                shape = CircleShape,
            ),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = AppTheme.colors.primary,
        )
    }
}