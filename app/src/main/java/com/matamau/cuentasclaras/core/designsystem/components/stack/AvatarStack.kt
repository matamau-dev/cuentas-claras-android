package com.matamau.cuentasclaras.core.designsystem.components.stack

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme

@Composable
fun AvatarStack(
    initials: List<String>,
    modifier: Modifier = Modifier,
    avatarSize: Dp = 36.dp,
    overLap: Dp = 12.dp,
    maxVisible: Int = 4
) {
    val visibleInitials = initials.take(n = maxVisible)
    val extraCount = initials.size - maxVisible

    Row(modifier = modifier) {
        Row(modifier = modifier) {
            visibleInitials.forEachIndexed { index, text ->
                val backgroundColor = if (index == 0) AppTheme.colors.primary else AppTheme.colors.tertiary
                val textColor = if (index == 0) AppTheme.colors.onPrimary else AppTheme.colors.onSurface

                Box(
                    modifier = Modifier
                        .offset(x = -(overLap * index))
                        .zIndex(-index.toFloat())
                        .size(avatarSize)
                        .clip(CircleShape)
                        .background(color = backgroundColor)
                        .border(width = 2.dp, color = AppTheme.colors.surface, shape = CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = text,
                        style = AppTheme.typography.labelSmall,
                        color = textColor,
                    )
                }
            }

            if (extraCount > 0) {
                Box(
                    modifier = Modifier
                        .offset(x = -(overLap * visibleInitials.size))
                        .zIndex(-visibleInitials.size.toFloat())
                        .size(avatarSize)
                        .clip(CircleShape)
                        .background(AppTheme.colors.onSurfaceVariant)
                        .border(width = 2.dp, color = AppTheme.colors.surface, shape = CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "+$extraCount",
                        style = AppTheme.typography.labelSmall,
                        color = AppTheme.colors.surface,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AvatarStackPreview() {
    CuentasClarasTheme {
        AvatarStack(
            initials = listOf("TÚ", "MP", "JR", "DC", "LM", "SG"),
            modifier = Modifier.padding(24.dp),
        )
    }
}