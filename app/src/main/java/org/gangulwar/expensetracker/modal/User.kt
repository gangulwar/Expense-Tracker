package org.gangulwar.expensetracker.modal

data class User(
    val username: String,
    val password: String,
    val emailId: String
)

object UserManager {
    private var currentUser: User? = null

    fun getCurrentUser(): User? {
        return currentUser
    }

    fun setCurrentUser(user: User) {
        currentUser = user
    }
}