package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.matamau.cuentasclaras.R
import com.matamau.cuentasclaras.core.designsystem.components.card.AppCard
import com.matamau.cuentasclaras.core.designsystem.components.field.InputText
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ExpenseDetailsSection(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
) {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        shape = AppTheme.shapes.medium,
    ) {
        Column(
            modifier = Modifier.padding(AppTheme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.md,
            ),
        ) {
            InputText(
                value = title,
                onValueChange = onTitleChange,
                modifier = Modifier.fillMaxWidth(),
                label = "Título",
                placeholder = "Super de la quincena",
            )

            InputText(
                value = description,
                onValueChange = onDescriptionChange,
                modifier = Modifier.fillMaxWidth(),
                label = "Descripción",
                placeholder = "Ej: compras de la semana",
                trailingIcon = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.shoppingmode
                        ),
                        contentDescription = null,
                    )
                },
            )
        }
    }
}