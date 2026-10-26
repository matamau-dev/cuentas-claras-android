package com.matamau.cuentasclaras.feature.group.presentation.detail.components.expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matamau.cuentasclaras.core.designsystem.theme.AppColorsSemantic
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.abs

@Composable
fun ExpenseItem(
    month: String,
    day: String,
    title: String,
    subtitle: String,
    amount: Double,
    splitInfo: String,
    onExpenseDetail: () -> Unit,
) {
    val isPositive = amount >= 0
    val amountColor =
        if (isPositive) {
            AppColorsSemantic.Success
        } else {
            AppColorsSemantic.Attention
        }

    val formattedAmount =
        NumberFormat.getCurrencyInstance(
            Locale("es", "MX"),
        ).format(abs(amount))

    val sign = if (isPositive) "+" else "-"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.lg)
            .clickable {
                onExpenseDetail()
            },
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.md),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DateBadge(
            month = month,
            day = day,
        )

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = title,
                style = AppTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.onSurface,
            )

            Text(
                text = subtitle,
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onSurfaceVariant,
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                text = "$sign$formattedAmount",
                color = amountColor,
                fontWeight = FontWeight.Bold,
                style = AppTheme.typography.labelLarge,
            )

            Text(
                text = splitInfo,
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun DateBadge(
    month: String,
    day: String,
) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(AppTheme.colors.background)
            .border(
                width = 2.dp,
                color = AppTheme.colors.outline,
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = month,
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.onBackground,
            )

            Text(
                text = day,
                style = AppTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.onBackground,
            )
        }
    }
}