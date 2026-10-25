package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.card.AppElevatedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ProfileSettingsCard(
    settings: List<SettingItem>,
    modifier: Modifier = Modifier,
) {
    AppElevatedCard (
        modifier = modifier.fillMaxWidth(),
        shape = AppTheme.shapes.medium,
    ) {
        Column {
            settings.forEachIndexed { index, item ->
                ProfileSettingItem(item = item)

                if (index < settings.lastIndex) {
                    HorizontalDivider(
                        color = AppTheme.colors.outline,
                    )
                }
            }
        }
    }
}
