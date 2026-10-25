package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.components.chip.InviteChip
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.feature.expense.presentation.create.components.common.PersonChip


@Composable
fun ExpensePeopleSection(
    people: List<Pair<String, String>>,
    selectedPeople: Set<String>,
    onPersonClick: (String) -> Unit,
    onInviteClick: () -> Unit,
) {
    AppOutlinedCard(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(AppTheme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.lg,
            ),
        ) {
            Text(
                text = "QUIENES INCLUYEN",
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onBackground.copy(alpha = 0.5f),
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(
                    AppTheme.spacing.sm,
                ),
            ) {
                items(
                    items = people,
                    key = { it.first },
                ) { (initials, name) ->
                    PersonChip(
                        initials = initials,
                        name = name,
                        selected = initials in selectedPeople,
                        onClick = {
                            onPersonClick(initials)
                        },
                    )
                }

                item {
                    InviteChip(
                        onClick = onInviteClick,
                    )
                }
            }
        }
    }
}