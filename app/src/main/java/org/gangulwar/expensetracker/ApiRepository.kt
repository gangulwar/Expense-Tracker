package org.gangulwar.expensetracker

import android.content.Context
import android.os.Build
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
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
                ),
                TransactionModal(
                    LocalDateTime.parse("2023-11-05T09:00:00"),
                    200.0,
                    "Freelance payment",
                    "Transportation",
                    true
                ),
                TransactionModal(
                    LocalDateTime.parse("2023-11-05T09:00:00"),
                    200.0,
                    "Freelance payment",
                    "Transportation",
                    true
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

        @RequiresApi(Build.VERSION_CODES.O)
        fun getIncomeList(): List<TransactionModal> {
            val transaction11 = TransactionModal(
                LocalDateTime.parse("2023-11-11T08:45"),
                80.0,
                "Grocery shopping",
                "Grocery",
                false
            )

            val transaction12 = TransactionModal(
                LocalDateTime.parse("2023-11-12T14:10"),
                50.0,
                "Fitness class",
                "Health",
                false
            )

            val transaction13 = TransactionModal(
                LocalDateTime.parse("2023-11-13T20:30"),
                200.0,
                "Dinner date",
                "Food",
                false
            )

            val transaction14 = TransactionModal(
                LocalDateTime.parse("2023-11-14T11:25"),
                150.0,
                "Bookstore haul",
                "Transportation",
                false
            )

            val transaction15 = TransactionModal(
                LocalDateTime.parse("2023-11-15T18:15"),
                300.0,
                "Freelance project",
                "Grocery",
                true
            )

            val transaction16 = TransactionModal(
                LocalDateTime.parse("2023-11-16T16:50"),
                30.0,
                "Coffee shop",
                "Food",
                false
            )

            val transaction17 = TransactionModal(
                LocalDateTime.parse("2023-11-17T12:40"),
                45.0,
                "Online course",
                "Transportation",
                false
            )

            val transaction18 = TransactionModal(
                LocalDateTime.parse("2023-11-18T22:05"),
                100.0,
                "Concert tickets",
                "Health",
                false
            )

            val transaction19 = TransactionModal(
                LocalDateTime.parse("2023-11-19T19:20"),
                25.0,
                "Snacks",
                "Food",
                false
            )

            val transaction20 = TransactionModal(
                LocalDateTime.parse("2023-11-20T09:30"),
                120.0,
                "Medical checkup",
                "Health",
                false
            )

            val transactionList: List<TransactionModal> = listOf(
                transaction11, transaction12, transaction13, transaction14, transaction15,
                transaction16, transaction17, transaction18, transaction19, transaction20
            )

            return transactionList
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getExpenseList(): List<TransactionModal> {
            val transaction11 = TransactionModal(
                LocalDateTime.parse("2023-11-11T08:45"),
                80.0,
                "Grocery shopping",
                "Grocery",
                false
            )

            val transaction12 = TransactionModal(
                LocalDateTime.parse("2023-11-12T14:10"),
                50.0,
                "Fitness class",
                "Health",
                false
            )

            val transaction13 = TransactionModal(
                LocalDateTime.parse("2023-11-13T20:30"),
                200.0,
                "Dinner date",
                "Food",
                false
            )

            val transaction14 = TransactionModal(
                LocalDateTime.parse("2023-11-14T11:25"),
                150.0,
                "Bookstore haul",
                "Transportation",
                false
            )

            val transaction15 = TransactionModal(
                LocalDateTime.parse("2023-11-15T18:15"),
                300.0,
                "Freelance project",
                "Grocery",
                true
            )

            val transaction16 = TransactionModal(
                LocalDateTime.parse("2023-11-16T16:50"),
                30.0,
                "Coffee shop",
                "Food",
                false
            )

            val transaction17 = TransactionModal(
                LocalDateTime.parse("2023-11-17T12:40"),
                45.0,
                "Online course",
                "Transportation",
                false
            )

            val transaction18 = TransactionModal(
                LocalDateTime.parse("2023-11-18T22:05"),
                100.0,
                "Concert tickets",
                "Health",
                false
            )

            val transaction19 = TransactionModal(
                LocalDateTime.parse("2023-11-19T19:20"),
                25.0,
                "Snacks",
                "Food",
                false
            )

            val transaction20 = TransactionModal(
                LocalDateTime.parse("2023-11-20T09:30"),
                120.0,
                "Medical checkup",
                "Health",
                false
            )

            val transactionList: List<TransactionModal> = listOf(
                transaction11, transaction12, transaction13, transaction14, transaction15,
                transaction16, transaction17, transaction18, transaction19, transaction20
            )

            return transactionList
        }

        fun newExpense(context: Context) {
            Toast.makeText(context, "Expense Added Successfully", LENGTH_SHORT).show()
        }
    }
}