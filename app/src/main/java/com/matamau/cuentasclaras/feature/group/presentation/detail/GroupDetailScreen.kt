package com.matamau.cuentasclaras.feature.group.presentation.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.appbar.AppBottomBar
import com.matamau.cuentasclaras.core.designsystem.components.buttons.AppSegmentedControl
import com.matamau.cuentasclaras.core.designsystem.components.buttons.SegmentedOption
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.navigation.Routes
import com.matamau.cuentasclaras.core.designsystem.components.appbar.DetailTopBar
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.EmptyExpensesState
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.GroupBalanceContent
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.GroupExpensesContent
import com.matamau.cuentasclaras.feature.group.presentation.detail.components.GroupSummary


@Composable
fun GroupGroupDetailScreen(
    onBackClick: () -> Unit,
    onAddExpense: () -> Unit,
    onNavigate: (Routes) -> Unit,
    onCreateGroup: () -> Unit,
) {
    var detailTab by remember { mutableIntStateOf(0) }
    val expenses = remember { emptyList<String>() }
    val avatarGroup = listOf("TÚ", "MP", "JR", "DC", "LM", "SG")

    Scaffold(
        topBar = {
            DetailTopBar(
                onBackClick = onBackClick,
                titleText = null
            )
        },
        bottomBar = {
            AppBottomBar(
                currentRoute = Routes.Home,
                onNavigate = onNavigate,
                onAddClick = onCreateGroup,
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(AppTheme.spacing.lg),
        ) {
            item {
                GroupSummary(
                    name = "Depa Condesa",
                    category = "Casa",
                    updatedText = "Actualizado hace 2 h",
                    memberInitials = avatarGroup,
                )
            }

            item {
                AppCard(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = AppTheme.elevation.L0,
                    containerColor = AppTheme.colors.surface,
                    shape = AppTheme.shapes.large,
                ) {
                    AppSegmentedControl(
                        modifier = Modifier.padding(AppTheme.spacing.xs),
                        options = listOf(
                            SegmentedOption(label = "Gastos"),
                            SegmentedOption(label = "Balance"),
                        ),
                        selectedIndex = detailTab,
                        onOptionSelected = { detailTab = it },
                    )
                }
            }

            when {
                expenses.isEmpty() -> {
                    item {
                        EmptyExpensesState(
                            onAddExpense = onAddExpense
                        )
                    }
                }

                detailTab == 0 -> {
                    item { GroupExpensesContent() }
                }

                detailTab == 1 -> {
                    item { GroupBalanceContent() }
                }
            }
        }
    }
}




