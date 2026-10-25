package com.matamau.cuentasclaras.feature.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.appbar.AppBottomBar
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonOutline
import com.matamau.cuentasclaras.core.designsystem.theme.AppColorsSemantic
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.navigation.Routes
import com.matamau.cuentasclaras.core.designsystem.components.appbar.DetailTopBar
import com.matamau.cuentasclaras.feature.profile.presentation.components.ProfileHeaderCard
import com.matamau.cuentasclaras.feature.profile.presentation.components.ProfileSettingsCard
import com.matamau.cuentasclaras.feature.profile.presentation.components.ProfileStats
import com.matamau.cuentasclaras.feature.profile.presentation.components.SettingItem


@Composable
fun ProfileScreen(
    onNavigate: (Routes) -> Unit,
    onCreateExpense: () -> Unit,
) {
    val stats = listOf(
        "5" to "Grupos",
        "24" to "Liquidados",
        "$2,378.30" to "Pendiente"
    )

    val settings = listOf<SettingItem>(
        SettingItem(
            Icons.Outlined.AccountBalanceWallet,
            "Métodos de cobro",
            "CLABE · SPEI",
        ),
        SettingItem(
            Icons.Outlined.Notifications,
            "Recordatorios",
            "Semanal",
        ),
        SettingItem(
            Icons.Outlined.PrivacyTip,
            "Privacidad y seguridad",
        ),
        SettingItem(
            Icons.AutoMirrored.Outlined.Help,
            "Ayuda",
        ),
    )

    Scaffold(
        topBar = {
            DetailTopBar(
                onBackClick = null,
                titleText = "Perfil",
                titleStyle = AppTheme.typography.labelLarge
            )
        },
        bottomBar = {
            AppBottomBar(
                currentRoute = Routes.Profile,
                onNavigate = onNavigate,
                onAddClick = onCreateExpense,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(AppTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.lg),
        ) {
            ProfileHeaderCard(
                name = "Mario Rodriguez",
                email = "mario@correo.com",
                initials = "MR",
                onEditProfile = { },
            )


            ProfileStats(
                stats = stats,
            )

            ProfileSettingsCard(
                settings = settings,
            )

            ButtonOutline(
                text = "Cerrar sesion",
                onClick = {},
                leadingIcon = Icons.AutoMirrored.Filled.Logout,
                colorText = AppColorsSemantic.Critical,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}