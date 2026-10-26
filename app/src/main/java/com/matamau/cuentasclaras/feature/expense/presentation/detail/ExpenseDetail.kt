package com.matamau.cuentasclaras.feature.expense.presentation.detail

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.matamau.cuentasclaras.core.designsystem.components.appbar.AppTopBar
import com.matamau.cuentasclaras.core.designsystem.components.appbar.DetailTopBar
import com.matamau.cuentasclaras.core.designsystem.components.buttons.ButtonPrimary
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import com.matamau.cuentasclaras.feature.expense.presentation.detail.components.ExpenseAmountCard
import com.matamau.cuentasclaras.feature.expense.presentation.detail.components.ExpenseInfoCard
import com.matamau.cuentasclaras.feature.expense.presentation.detail.components.ExpenseParticipantUi
import com.matamau.cuentasclaras.feature.expense.presentation.detail.components.ExpenseSplitCard
import com.matamau.cuentasclaras.feature.expense.presentation.detail.components.PaymentStatus

@Composable
fun ExpenseDetail(
    onBackClick: () -> Unit,
) {
    Scaffold(topBar = {
        AppTopBar {
            DetailTopBar(onBackClick = onBackClick, titleText = "Detalle del gasto")
        }
    }, bottomBar = {
        ButtonPrimary(
            text = "Marcar como pagado",
            onClick = {
                Log.d("ExpenseDetail", "Marcar como pagado")
            },
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = AppTheme.spacing.xl, vertical = AppTheme.spacing.md),
        )
    }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(AppTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.xl),
        ) {
            item {
                ExpenseAmountCard(
                    amount = "$18,400.00", category = "Casa"
                )
            }

            item {
                ExpenseInfoCard(
                    payer = "María",
                    expenseDate = "1 de marzo",
                    dueDate = "1 de abril",
                    recurrence = "Cada mes",
                    receipt = "Ver recibo",
                )
            }

            item {
                ExpenseSplitCard(
                    splitDescription = "Igual entre 4 personas",
                    participants = listOf(
                        ExpenseParticipantUi(
                            initials = "MR",
                            name = "María",
                            amount = "$4,600.00",
                            paymentStatus = PaymentStatus.PAYER
                        ),
                        ExpenseParticipantUi(
                            initials = "TÚ",
                            name = "Tú",
                            amount = "$4,600.00",
                            paymentStatus = PaymentStatus.PENDING
                        ),
                        ExpenseParticipantUi(
                            initials = "JN",
                            name = "Juan",
                            amount = "$4,600.00",
                            paymentStatus = PaymentStatus.PENDING
                        ),
                        ExpenseParticipantUi(
                            initials = "DC",
                            name = "Diego",
                            amount = "$4,600.00",
                            paymentStatus = PaymentStatus.PAID
                        ),
                    ),
                )
            }
        }
    }
}