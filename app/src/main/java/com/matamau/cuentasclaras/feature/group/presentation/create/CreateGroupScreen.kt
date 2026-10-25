package com.matamau.cuentasclaras.feature.group.presentation.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.components.chip.CategoryChip
import com.matamau.cuentasclaras.core.designsystem.components.chip.InviteChip
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.components.sheet.CategorySheet
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.components.appbar.DetailTopBar
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.common.PersonChip

@Composable
fun CreateGroupScreen(
    onBackClick: () -> Unit,
    onAddExpense: () -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var groupType by remember { mutableStateOf<String?>(null) }
    val groupTypes = remember {
        mutableStateListOf("Casa", "Viajes", "Eventos")
    }
    var showTypeSheet by remember { mutableStateOf(false) }
    val members = remember { mutableStateListOf("TÚ" to "Tú") }

    Scaffold(
        topBar = {
            DetailTopBar(onBackClick = onBackClick, titleText = "Nuevo grupo")
        },
        bottomBar = {
            ButtonPrimary(
                text = "Crear grupo",
                onClick = {
                    println("Crear grupo: $name, $groupType, $members")
                    onAddExpense()
                },
                enabled = name.isNotBlank() && groupType != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(horizontal = AppTheme.spacing.xl, vertical = AppTheme.spacing.md),
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(AppTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.xl),
        ) {
            item {
                AppCard(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(AppTheme.spacing.lg),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
                    ) {
                        InputText(
                            value = name,
                            onValueChange = { name = it },
                            modifier = Modifier.fillMaxWidth(),
                            label = "Nombre del grupo",
                            placeholder = "Depa Condesa",
                        )
                    }
                }
            }

            item {
                AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(AppTheme.spacing.lg),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
                    ) {
                        Text(
                            text = "TIPO DE GRUPO",
                            style = AppTheme.typography.labelSmall,
                            color = AppTheme.colors.onBackground.copy(alpha = 0.5f),
                        )
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.sm)) {
                            items(groupTypes) { type ->
                                CategoryChip(
                                    label = type,
                                    selected = type == groupType,
                                    onClick = { groupType = type },
                                )
                            }
                            item {
                                InviteChip(label = "Nuevo", onClick = { showTypeSheet = true })
                            }
                        }
                    }
                }
            }

            item {
                AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(AppTheme.spacing.lg),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md),
                    ) {
                        Text(
                            text = "MIEMBROS",
                            style = AppTheme.typography.labelSmall,
                            color = AppTheme.colors.onBackground.copy(alpha = 0.5f),
                        )
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.sm)) {
                            items(members) { (initials, memberName) ->
                                PersonChip(
                                    initials = initials,
                                    name = memberName,
                                    selected = true,
                                    onClick = {},
                                )
                            }
//                            item {
//                                InviteChip(label = "Nuevo", onClick = { showTypeSheet = true })
//                            }
                        }
                    }
                }
            }
        }
    }

    if (showTypeSheet) {
        CategorySheet(
            title = "Nuevo tipo de grupo",
            placeholder = "Roomies",
            existing = groupTypes,
            onSave = { newType ->
                groupTypes.add(newType)
                groupType = newType
                showTypeSheet = false
            },
            onDismiss = { showTypeSheet = false },
        )
    }
}