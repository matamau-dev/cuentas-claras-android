package com.matamau.cuentasclaras.feature.expense.presentation.create.components

enum class InviteStatus {
    Accepted, Pending, Declined
}

data class Participant(
    val id: String,
    val initials: String,
    val name: String,
    val amount: String,
    val status: InviteStatus,
)