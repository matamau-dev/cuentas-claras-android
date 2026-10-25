package com.matamau.cuentasclaras.feature.home.presentation

import android.R.attr.onClick
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.matamau.cuentasclaras.core.designsystem.components.appbar.AppBottomBar
import com.matamau.cuentasclaras.core.designsystem.components.appbar.AppTopBar
import com.matamau.cuentasclaras.core.designsystem.components.chip.CategoryChip
import com.matamau.cuentasclaras.core.designsystem.theme.AppColorsSemantic
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.navigation.Routes
import com.matamau.cuentasclaras.feature.home.presentation.components.BalanceSummaryCard
import com.matamau.cuentasclaras.feature.home.presentation.components.GroupCard
import com.matamau.cuentasclaras.feature.home.presentation.components.HomeBottomBar
import com.matamau.cuentasclaras.feature.home.presentation.components.HomeTopBar


@Composable
fun HomeScreen(
    userName: String,
    onOpenClearingDetails: () -> Unit,
    onCreateGroup: () -> Unit,
    onSelectTab: (Routes) -> Unit
) {
    var notificationCount by remember { mutableIntStateOf(value = 1) }
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Casa", "Viajes", "Eventos")

    Scaffold(
        topBar = {
            AppTopBar {
                HomeTopBar(
                    userName = userName,
                    notificationCount = notificationCount
                )
            }
        },
        bottomBar = {
            AppBottomBar(
                currentRoute = Routes.Home,
                onNavigate = onSelectTab,
                onAddClick = onCreateGroup,
            )
        },


    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.Start
        ) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = AppTheme.spacing.lg),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.sm),
                modifier = Modifier.padding(vertical = AppTheme.spacing.sm),
            ) {
                items(categories) { category ->
                    CategoryChip(
                        label = category,
                        selected = category == selectedCategory,
                        onClick = { selectedCategory = category },
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = AppTheme.spacing.lg)
            ) {
                item {
                    BalanceSummaryCard(
                        totalBalance = "$1,331.50",
                        groupCount = 5,
                        owedToYou = "$1,855.00",
                        youOwe = "$420.00",
                        modifier = Modifier.padding(horizontal = AppTheme.spacing.lg),
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(AppTheme.spacing.xxl))
                    Text(
                        text = "Tus Grupos",
                        style = AppTheme.typography.labelMedium,
                        color = AppTheme.colors.primary,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = AppTheme.spacing.md),
                    )
                    Spacer(modifier = Modifier.height(AppTheme.spacing.xl))
                }

                item {
                    Column(
                        modifier = Modifier.padding(
                            start = AppTheme.spacing.lg,
                            end = AppTheme.spacing.md
                        )
                    ) {
                        GroupCard(
                            title = "Departamento de Condesa",
                            category = "Casa",
                            memberCount = 4,
                            memberInitials = listOf("TÚ", "MP", "JR", "DC", "LM", "SG"),
                            balanceLabel = "Te deben",
                            balanceAmount = "$1,240.00",
                            balanceColor = AppColorsSemantic.Success,
                            onClick = onOpenClearingDetails
                        )
                        Spacer(modifier = Modifier.height(AppTheme.spacing.lg))
                        GroupCard(
                            title = "Roadtrip Oaxaca.",
                            category = "Viajes",
                            memberCount = 4,
                            memberInitials = listOf("TÚ", "MP", "JR", "DC", "LM", "SG"),
                            balanceLabel = "Debes",
                            balanceAmount = "$1,240.00",
                            balanceColor = AppTheme.colors.error,
                            onClick = onOpenClearingDetails
                        )
                        Spacer(modifier = Modifier.height(AppTheme.spacing.lg))
                        GroupCard(
                            title = "Departamento de Condesa",
                            category = "Casa",
                            memberCount = 4,
                            memberInitials = listOf("TÚ", "MP", "JR", "DC", "LM", "SG"),
                            balanceLabel = "Te deben",
                            balanceAmount = "$1,240.00",
                            balanceColor = AppColorsSemantic.Success,
                            onClick = { onOpenClearingDetails }
                        )
                        Spacer(modifier = Modifier.height(AppTheme.spacing.lg))
                        GroupCard(
                            title = "Roadtrip Oaxaca.",
                            category = "Viajes",
                            memberCount = 4,
                            memberInitials = listOf("TÚ", "MP", "JR", "DC", "LM", "SG"),
                            balanceLabel = "Debes",
                            balanceAmount = "$1,240.00",
                            balanceColor = AppTheme.colors.error,
                            onClick = onOpenClearingDetails
                        )
                        Spacer(modifier = Modifier.height(AppTheme.spacing.lg))
                    }
                }
            }


        }
    }
}










