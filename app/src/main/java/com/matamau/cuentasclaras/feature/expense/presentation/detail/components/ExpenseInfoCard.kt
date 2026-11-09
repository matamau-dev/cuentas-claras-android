package com.matamau.cuentasclaras.feature.expense.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil3.compose.AsyncImage
import com.matamau.cuentasclaras.R
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ExpenseInfoCard(
    payer: String,
    expenseDate: String,
    dueDate: String,
    recurrence: String,
    modifier: Modifier = Modifier,
) {


    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.xs,
        ),
    ) {
        Text(
            text = "Información",
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground,
        )

        AppOutlinedCard(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.padding(AppTheme.spacing.lg),
            ) {
                ExpenseInfoRow(
                    label = "Pagó",
                    value = payer,
                )

                ExpenseInfoRow(
                    label = "Fecha del gasto",
                    value = expenseDate,
                )

                ExpenseInfoRow(
                    label = "Fecha límite",
                    value = dueDate,
                )

                ExpenseInfoRow(
                    label = "Se repite",
                    value = recurrence,
                )

                ExpenseReceiptRow()
            }
        }
    }
}

@Composable
private fun ExpenseInfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.md),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onSurfaceVariant,
        )

        Text(
            text = value,
            style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.onSurface,
        )
    }
}


@Composable
private fun ExpenseReceiptRow(
    modifier: Modifier = Modifier
) {
    var showReceipt by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.md),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Comprobante",
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onSurfaceVariant,
        )

        TextButton(
            onClick = { showReceipt = true },
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                "Ver Comprobante",
                color = AppTheme.colors.secondary,
                textDecoration = TextDecoration.Underline
            )
        }
    }

    if (showReceipt) {
        ViewReceipt(
            onDismissRequest = {
                showReceipt = false
            },
        )
    }
}

@Composable()
private fun ViewReceipt(
//    image: Any,
//    title: String,
    onDismissRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        var scale by remember { mutableFloatStateOf(1f) }
        var offset by remember { mutableStateOf(Offset.Zero) }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.85f)
                .clip(AppTheme.shapes.large)
                .background(Color.Black)
        ) {
            AsyncImage(
                model = R.drawable.receipt,
                contentDescription = "Comprobante del gasto",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, zoom, _ ->
                            scale = (scale * zoom).coerceIn(1f, 5f)
                            offset = if (scale > 1f) offset + pan else Offset.Zero
                        }
                    }
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        translationX = offset.x
                        translationY = offset.y
                    })

            Text(
                text = "Comprobante del gasto",
                style = AppTheme.typography.labelLarge,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(AppTheme.spacing.lg),
            )

            IconButton(
                onClick = onDismissRequest,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(AppTheme.spacing.sm)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Cerrar",
                    tint = Color.White
                )
            }
        }
    }
}