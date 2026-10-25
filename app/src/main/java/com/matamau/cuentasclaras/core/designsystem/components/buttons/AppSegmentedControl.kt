package com.matamau.cuentasclaras.core.designsystem.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.theme.CuentasClarasTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow

data class SegmentedOption(
    val label: String,
    val icon: ImageVector? = null,
)


@Composable
fun AppSegmentedControl(
    options: List<SegmentedOption>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(999.dp)
    val segmentShape = RoundedCornerShape(999.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = AppTheme.colors.background,
                shape = shape,
            )
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        options.forEachIndexed { index, option ->
            val selected = index == selectedIndex

            val backgroundColor by animateColorAsState(
                targetValue = if (selected) {
                    AppTheme.colors.primary
                } else {
                    Color.Transparent
                },
                label = "segmentBackground",
            )

            val contentColor by animateColorAsState(
                targetValue = if (selected) {
                    AppTheme.colors.onPrimary
                } else {
                    AppTheme.colors.onSurface
                },
                label = "segmentContent",
            )

            Row(
                modifier = Modifier
                    .weight(1f)
                    .clip(segmentShape)
                    .background(backgroundColor)
                    .clickable(
                        indication = null,
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                    ) {
                        onOptionSelected(index)
                    }
                    .padding(
                        horizontal = AppTheme.spacing.xs,
                        vertical = AppTheme.spacing.sm,
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                option.icon?.let { icon ->
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = contentColor,
                        modifier = Modifier.size(16.dp),
                    )

                    Spacer(
                        modifier = Modifier.width(
                            AppTheme.spacing.xs,
                        ),
                    )
                }

                Text(
                    text = option.label,
                    style = AppTheme.typography.labelLarge,
                    color = contentColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            // Separador entre opciones no seleccionadas.
            if (
                index < options.lastIndex &&
                index != selectedIndex &&
                index + 1 != selectedIndex
            ) {
                Box(
                    modifier = Modifier
                        .padding(vertical = AppTheme.spacing.sm)
                        .width(1.dp)
                        .height(20.dp)
                        .background(AppTheme.colors.outline),
                )
            }
        }
    }
}
