package com.matamau.cuentasclaras.feature.expense.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.components.card.AppOutlinedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppColorsSemantic
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


enum class PaymentStatus {
    PAYER,
    PAID,
    PENDING
}

data class ExpenseParticipantUi(
    val initials: String,
    val name: String,
    val amount: String,
    val paymentStatus: PaymentStatus
) {
    val status: String
        get() = when (paymentStatus) {
            PaymentStatus.PAYER -> "Pagó"
            PaymentStatus.PAID -> "Pagado ✓"
            PaymentStatus.PENDING -> "Pendiente"
        }
}

@Composable
fun ExpenseSplitCard(
    participants: List<ExpenseParticipantUi>,
    splitDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(
            AppTheme.spacing.md
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.xs
            )
        ) {
            Text(
                text = "Cómo se dividió",
                style = AppTheme.typography.titleLarge,
                color = AppTheme.colors.onBackground,
            )

            Text(
                text = splitDescription,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.onSurfaceVariant,
            )
        }

        AppOutlinedCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(
                    vertical = AppTheme.spacing.sm
                )
            ) {
                participants.forEachIndexed { index, participant ->
                    ExpenseParticipantRow(
                        participant = participant,
                    )

                    if (index < participants.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(
                                horizontal = AppTheme.spacing.lg
                            ), color = AppTheme.colors.outline.copy(
                                alpha = 0.35f
                            )
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun ExpenseParticipantRow(participant: ExpenseParticipantUi) {
    val statusColor = paymentStatusColor(participant.paymentStatus)
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppTheme.spacing.lg, vertical = AppTheme.spacing.md
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(
                    AppTheme.colors.primary.copy(alpha = 0.12f),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = participant.initials,
                style = AppTheme.typography.labelMedium,
                color = AppTheme.colors.primary,
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.xs,
            ),
        ) {
            Text(
                text = participant.name,
                style = AppTheme.typography.titleSmall,
                color = AppTheme.colors.onSurface,
            )

            Text(
                text = participant.amount,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.onSurfaceVariant,
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(
                    color = paymentStatusBackground(
                        participant.paymentStatus
                    )
                )
                .border(
                    width = 1.dp,
                    color = statusColor.copy(alpha = 0.25f),
                    shape = RoundedCornerShape(50)
                )
                .padding(
                    horizontal = AppTheme.spacing.sm,
                    vertical = AppTheme.spacing.xs
                )
        ) {
            Text(
                text = participant.status,
                style = AppTheme.typography.labelSmall,
                color = statusColor
            )
        }
    }
}

@Composable
private fun paymentStatusColor(
    status: PaymentStatus
): Color {
    return when (status) {
        PaymentStatus.PAYER -> AppTheme.colors.primary
        PaymentStatus.PAID -> AppColorsSemantic.Success
        PaymentStatus.PENDING -> AppColorsSemantic.Attention
    }
}

@Composable
private fun paymentStatusBackground(
    status: PaymentStatus
): Color {
    val color = paymentStatusColor(status)

    return color.copy(alpha = 0.12f)
}