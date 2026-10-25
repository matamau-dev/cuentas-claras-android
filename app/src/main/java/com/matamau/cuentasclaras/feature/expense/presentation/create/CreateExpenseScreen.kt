package com.matamau.cuentasclaras.feature.expense.presentation.create

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.matamau.cuentasclaras.core.designsystem.component.field.SelectField
import com.matamau.cuentasclaras.core.designsystem.components.buttons.AppSegmentedControl
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.components.buttons.SegmentedOption
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.components.chip.CategoryChip
import com.matamau.cuentasclaras.core.designsystem.components.chip.InviteChip
import com.matamau.cuentasclaras.core.designsystem.components.field.datefield.DateField
import com.matamau.cuentasclaras.core.designsystem.components.field.SelectOption
import com.matamau.cuentasclaras.core.designsystem.components.sheet.CategorySheet
import com.matamau.cuentasclaras.core.designsystem.components.toggle.Toggle
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.core.designsystem.components.appbar.DetailTopBar
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.ExpenseAmountSection
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.ExpenseDetailsSection
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.ExpenseModal
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.ExpenseParticipantsCard
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.ExpensePeopleSection
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.ExpenseSplitSection
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.InviteStatus
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.Participant
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.PartsSplitModal
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.PercentageSplitModal
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.common.ExpenseModalType
import java.time.LocalDate

@Composable
@ExperimentalMaterial3Api
fun CreateExpenseScreen(
    onBackClick: () -> Unit,
) {
    val focusManager = LocalFocusManager.current

    val people = listOf(
        "TU" to "Tu",
        "MR" to "Maria",
        "JN" to "Juan",
    )

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val payerOptions = people.map { (initials, name) ->
        SelectOption(
            id = initials, label = name
        )
    }


    val categories = remember { mutableStateListOf("Comida", "Servicios", "Transporte") }
    var isRecurring by remember { mutableStateOf(value = false) }

    var selectedCategory by remember { mutableStateOf<String?>(null) }

    var amount by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf<LocalDate?>(null) }
    var paidBy by remember { mutableStateOf(payerOptions.first()) }
    var showTypeSheet by remember { mutableStateOf(false) }
    var activeModal by remember {
        mutableStateOf<ExpenseModalType?>(null)
    }

    var inviteEmail by remember { mutableStateOf("") }
    var inviteName by remember { mutableStateOf("") }


    var selectedPeople by remember {
        mutableStateOf(setOf("TU", "MR", "JN"))
    }

    var divisor by remember { mutableIntStateOf(0) }
    var frequency by remember { mutableIntStateOf(0) }


    val participants = listOf(
        Participant(
            id = "1",
            initials = "TU",
            name = "Tu",
            amount = "$310.20",
            status = InviteStatus.Pending,
        ),
        Participant(
            id = "2",
            initials = "MR",
            name = "Maria",
            amount = "$310.20",
            status = InviteStatus.Accepted,
        ),
        Participant(
            id = "3",
            initials = "JN",
            name = "Juan",
            amount = "$310.20",
            status = InviteStatus.Declined,
        ),
    )

    Scaffold(
        topBar = {
            DetailTopBar(
                onBackClick = onBackClick, titleText = "Nuevo Gasto"
            )
        },
        bottomBar = {
            ButtonPrimary(
                text = "Guardar Gasto",
                onClick = {
                    print("GUARDAR GASTO")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(
                        horizontal = AppTheme.spacing.xl,
                        vertical = AppTheme.spacing.md,
                    ),
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(AppTheme.spacing.lg)
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                ) {
                    focusManager.clearFocus()
                },
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.md,
            ),
        ) {
            item {
                ExpenseAmountSection(
                    amount = amount,
                    onAmountChange = { amount = it },
                )
            }

            item {
                ExpenseDetailsSection(
                    title = title,
                    onTitleChange = { title = it },
                    description = description,
                    onDescriptionChange = { description = it },
                )
            }

            //PAGO
            item {
                AppOutlinedCard(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            AppTheme.spacing.md
                        ),
                        modifier = Modifier.padding(AppTheme.spacing.lg),
                    ) {
                        Text(
                            text = "PAGÓ",
                            style = AppTheme.typography.labelSmall,
                            color = AppTheme.colors.onBackground.copy(alpha = 0.5f)
                        )
                        SelectField(
                            options = payerOptions,
                            selected = paidBy,
                            onSelectedChange = { paidBy = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

            //FECHA LIMITE
            item {
                AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(AppTheme.spacing.lg),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
                    ) {
                        Text(
                            text = "FECHA LÍMITE",
                            style = AppTheme.typography.labelSmall,
                            color = AppTheme.colors.onBackground.copy(alpha = 0.5f),
                        )
                        DateField(
                            value = dueDate,
                            onValueChange = { dueDate = it },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = "Selecciona una fecha",
                        )
                    }
                }
            }

            //CATEGORIA
            item {
                AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(AppTheme.spacing.lg),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
                    ) {
                        Text(
                            text = "CATEGORÍA",
                            style = AppTheme.typography.labelSmall,
                            color = AppTheme.colors.onBackground.copy(alpha = 0.5f),
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.sm)
                        ) {
                            items(categories) { category ->
                                CategoryChip(
                                    label = category,
                                    selected = category == selectedCategory,
                                    onClick = {
                                        selectedCategory =
                                            if (category == selectedCategory) null else category
                                    },
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
                ExpensePeopleSection(
                    people = people,
                    selectedPeople = selectedPeople,
                    onPersonClick = { initials ->
                        selectedPeople = if (initials in selectedPeople) {
                            selectedPeople - initials
                        } else {
                            selectedPeople + initials
                        }
                    },
                    onInviteClick = {
                        activeModal = ExpenseModalType.InvitePeople
                    },
                )
            }

            //SE REPITE
            item {
                AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md),
                    ) {
                        Toggle(
                            label = "Se repite",
                            description = "Configura cada cuánto quieres que se repita.",
                            checked = isRecurring,
                            onCheckedChange = { isRecurring = it },
                        )
                        if (isRecurring) {
                            AppSegmentedControl(
                                options = listOf(
                                    SegmentedOption("Diario"),
                                    SegmentedOption("Semanal"),
                                    SegmentedOption("Mensual"),
                                    SegmentedOption("Anual"),
                                ),
                                selectedIndex = frequency,
                                onOptionSelected = { frequency = it },
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                    }
                }
            }

            item {
                ExpenseSplitSection(
                    selectedIndex = divisor,
                    onOptionSelected = { index ->
                        divisor = index
                        when (index) {
                            1 -> activeModal = ExpenseModalType.PartsSplit
                            2 -> activeModal = ExpenseModalType.PercentageSplit
                            else -> activeModal = null
                        }
                    },
                )
            }

            item {
                ExpenseParticipantsCard(
                    participants = participants,
                )
            }
        }
    }

    val selectedPeopleNames =
        people.filter { (initials, _) -> initials in selectedPeople }.map { (_, name) -> name }

    when (activeModal) {
        ExpenseModalType.InvitePeople -> {
            ExpenseModal(
                onDismissRequest = {
                    activeModal = null
                },
                onSendInvitation = { name, email ->
                    println("Invitar a $name ($email)")

                    inviteName = ""
                    inviteEmail = ""
                    activeModal = null
                },
                sheetState = sheetState,
                containerColor = AppTheme.colors.background,
                inviteName = inviteName,
                onInviteNameChange = { inviteName = it },
                inviteEmail = inviteEmail,
                onInviteEmailChange = { inviteEmail = it },
            )
        }


        ExpenseModalType.PercentageSplit -> {
            PercentageSplitModal(
                onDismissRequest = {
                    activeModal = null
                },
                sheetState = sheetState,
                peopleNames = selectedPeopleNames,
                onSave = { percentages ->
                    println("Porcentajes: $percentages")
                    activeModal = null
                },
            )
        }

        ExpenseModalType.PartsSplit -> {
            PartsSplitModal(
                onDismissRequest = {
                    activeModal = null
                },
                sheetState = sheetState,
                peopleNames = selectedPeopleNames,
                onSave = { parts ->
                    println("Partes: $parts")
                    activeModal = null
                },
            )
        }

        null -> Unit
        else -> {}
    }

    if (showTypeSheet) {
        CategorySheet(
            title = "Nueva categoria",
            placeholder = "Mascotas",
            existing = categories,
            onSave = { newCategory ->
                categories.add(newCategory)
                selectedCategory = newCategory
                showTypeSheet = false
            },
            onDismiss = { showTypeSheet = false },
        )
    }

}