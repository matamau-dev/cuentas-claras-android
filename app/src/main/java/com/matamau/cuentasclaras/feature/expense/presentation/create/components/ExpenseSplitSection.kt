package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CallSplit
import androidx.compose.material.icons.filled.DragHandle
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.buttons.AppSegmentedControl
import com.matamau.cuentasclaras.core.designsystem.components.buttons.SegmentedOption
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ExpenseSplitSection(
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
) {
    AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(AppTheme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.md,
            ),
        ) {
            Text(
                text = "COMO DIVIDIR",
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onBackground.copy(alpha = 0.5f),
            )

            AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
                AppSegmentedControl(
                    options = listOf(
                        SegmentedOption(
                            label = "Igual",
                            icon = Icons.Filled.DragHandle,
                        ),
                        SegmentedOption(
                            label = "Partes",
                            icon = Icons.AutoMirrored.Filled.CallSplit,
                        ),
                        SegmentedOption(
                            label = "Porcentaje",
                            icon = Icons.Filled.Percent,
                        ),
                    ),
                    selectedIndex = selectedIndex,
                    onOptionSelected = onOptionSelected,
                )
            }
        }
    }
}