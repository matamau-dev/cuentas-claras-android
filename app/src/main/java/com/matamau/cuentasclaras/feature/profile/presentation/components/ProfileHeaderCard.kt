package com.matamau.cuentasclaras.feature.profile.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ProfileHeaderCard(
    name: String,
    email: String,
    initials: String,
    onEditProfile: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AppCard(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.spacing.lg),
            horizontalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.lg,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProfileAvatar(initials = initials)

            ProfileUserInfo(
                name = name,
                email = email,
                onEditProfile = onEditProfile,
                modifier = Modifier.weight(1f),
            )
        }
    }
}
