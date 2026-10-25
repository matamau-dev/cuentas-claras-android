package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ProfileStats(
    stats: List<Pair<String, String>>,
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.md,
        ),
    ) {
        stats.forEach { (value, label) ->
            ProfileStatCard(
                value = value,
                label = label,
                modifier = Modifier.weight(1f),
            )
        }
    }
}
