package com.matamau.cuentasclaras.feature.auth.presentation.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.components.buttons.AppSegmentedControl
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonSecondary
import com.matamau.cuentasclaras.core.designsystem.components.buttons.SegmentedOption
import com.matamau.cuentasclaras.core.designsystem.components.card.AppElevatedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.feature.login.presentation.LoginScreen
import com.matamau.cuentasclaras.feature.register.presentation.RegisterScreen

@Composable
fun AuthScreen(
    onAuthSuccess: () -> Unit,
) {
    var authTab by remember { mutableIntStateOf(0) }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focusManager.clearFocus()
            }
            .padding(horizontal = AppTheme.spacing.lg),
    ) {

        Spacer(modifier = Modifier.height(64.dp))

        Text(
            text = "Las cuentas claras,\nla amistad larga.",
            style = AppTheme.typography.displaySmall,
            color = AppTheme.colors.onSurface,
        )

        Spacer(modifier = Modifier.height(AppTheme.spacing.sm))

        Text(
            text = "Divide gastos con amigos, viajes y roommates.",
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.onSurfaceVariant,
        )

        Spacer(modifier = Modifier.height(32.dp))

        AppElevatedCard(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .padding(AppTheme.spacing.xl)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.lg)
            ) {

                AppSegmentedControl(
                    options = listOf(
                        SegmentedOption(label = "Iniciar sesión"),
                        SegmentedOption(label = "Crear cuenta"),
                    ),
                    selectedIndex = authTab,
                    onOptionSelected = { authTab = it },
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {

                    Text(
                        text = if (authTab == 0)
                            "Inicia sesión"
                        else
                            "Crea tu cuenta",
                        style = AppTheme.typography.titleLarge,
                        color = AppTheme.colors.onSurface
                    )

                    Text(
                        text = if (authTab == 0)
                            "Continúa donde te quedaste."
                        else
                            "Solo te tomará un minuto.",
                        style = AppTheme.typography.bodySmall,
                        color = AppTheme.colors.onSurfaceVariant
                    )
                }

                if (authTab == 0) {
                    LoginScreen(onSubmit = onAuthSuccess)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(
                            contentPadding = PaddingValues(0.dp),
                            onClick = { println("XDXD") }
                        ) {
                            Text(
                                text = "¿Olvidaste tu contraseña?",
                                style = AppTheme.typography.bodySmall,
                                color = AppTheme.colors.secondary
                            )
                        }
                    }
                } else {
                    RegisterScreen(onSubmit = onAuthSuccess)
                }

                ButtonSecondary(
                    text = if (authTab == 0) "Entrar" else "Crear cuenta",
                    onClick = onAuthSuccess,
                    trailingIcon = Icons.AutoMirrored.Filled.ArrowRightAlt,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }

        Spacer(modifier = Modifier.height(AppTheme.spacing.xxl))
    }
}