package com.matamau.cuentasclaras.feature.expense.presentation.create.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.components.card.AppElevatedCard
import com.matamau.cuentasclaras.core.designsystem.theme.AppColorsSemantic
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme


@Composable
fun ExpenseParticipantsCard(
    participants: List<Participant>,
) {
    AppElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = AppTheme.shapes.medium,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.spacing.lg),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "División entre ${participants.size}",
                    style = AppTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.onSurface,
                )

                Text(
                    text = "$310.20 c/u",
                    style = AppTheme.typography.labelMedium,
                    color = AppTheme.colors.onSurfaceVariant,
                )
            }

            HorizontalDivider(
                color = AppTheme.colors.outline,
            )

            LazyColumn(
                modifier = Modifier.heightIn(max = 300.dp),
            ) {
                itemsIndexed(
                    items = participants,
                    key = { _, participant -> participant.id },
                ) { index, participant ->
                    ExpenseParticipantRow(
                        participant = participant,
                    )

                    if (index < participants.lastIndex) {
                        HorizontalDivider(
                            color = AppTheme.colors.outline,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExpenseParticipantRow(
    participant: Participant,
) {
    val statusColor = when (participant.status) {
        InviteStatus.Accepted -> AppColorsSemantic.Success
        InviteStatus.Pending -> AppTheme.colors.onSurfaceVariant
        InviteStatus.Declined -> AppColorsSemantic.Critical
    }

    val statusIcon = when (participant.status) {
        InviteStatus.Accepted -> Icons.Filled.Check
        InviteStatus.Pending -> Icons.Filled.Remove
        InviteStatus.Declined -> Icons.Filled.Close
    }

    val statusText = when (participant.status) {
        InviteStatus.Accepted -> "Aceptó"
        InviteStatus.Pending -> "Pendiente"
        InviteStatus.Declined -> "Rechazó"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.lg),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.sm,
            ),
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(AppTheme.colors.primary),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = participant.initials,
                    style = AppTheme.typography.labelSmall,
                    color = AppTheme.colors.onPrimary,
                )
            }

            Text(
                text = participant.name,
                style = AppTheme.typography.labelLarge,
                color = AppTheme.colors.onSurface,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                AppTheme.spacing.md,
            ),
        ) {
            Text(
                text = participant.amount,
                style = AppTheme.typography.labelMedium,
                color = AppTheme.colors.onSurface,
                fontWeight = FontWeight.Bold,
            )

            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(statusColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = statusIcon,
                    contentDescription = statusText,
                    tint = statusColor,
                    modifier = Modifier.size(14.dp),
                )
            }
        }
    }
}