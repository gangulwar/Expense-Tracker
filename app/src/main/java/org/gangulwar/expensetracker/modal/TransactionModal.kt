package org.gangulwar.expensetracker.modal

import java.time.LocalDateTime

data class TransactionModal(
    val dateTime: LocalDateTime,
    val amount: Double,
    val description: String,
    val category: String,
    val isCredit: Boolean
)
