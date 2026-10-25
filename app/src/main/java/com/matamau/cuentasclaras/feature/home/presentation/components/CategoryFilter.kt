package com.matamau.cuentasclaras.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.chip.CategoryChip
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme

@Composable
fun CategoryFilter(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = AppTheme.spacing.lg,
        ),
        horizontalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.sm,
        ),
    ) {
        items(categories) { category ->
            CategoryChip(
                label = category,
                selected = category == selectedCategory,
                onClick = {
                    onCategorySelected(category)
                },
            )
        }
    }
}