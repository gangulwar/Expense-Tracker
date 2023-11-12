package org.gangulwar.expensetracker

import android.os.Build
import androidx.annotation.RequiresApi
import org.gangulwar.expensetracker.modal.TransactionModal
import java.time.LocalDateTime

class ApiRepository {

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun getRecentsIncomeList(): List<TransactionModal> {
            val incomeList = listOf(
                TransactionModal(
                    LocalDateTime.parse("2023-11-01T08:30:00"),
                    50.0,
                    "Grocery shopping",
                    "Grocery",
                    false
                ),
                TransactionModal(
                    LocalDateTime.parse("2023-11-02T15:45:00"),
                    20.0,
                    "Coffee with friends",
                    "Food",
                    false
                ),
                TransactionModal(
                    LocalDateTime.parse("2023-11-03T12:00:00"),
                    100.0,
                    "Monthly rent",
                    "Health",
                    false
                ),
                TransactionModal(
                    LocalDateTime.parse("2023-11-04T18:20:00"),
                    80.0,
                    "Dinner at a restaurant",
                    "Food",
                    false
                ),
                TransactionModal(
                    LocalDateTime.parse("2023-11-05T09:00:00"),
                    200.0,
                    "Freelance payment",
                    "Transportation",
                    true
                )
            )

            return incomeList
        }
    }
}