package org.gangulwar.expensetracker.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.gangulwar.expensetracker.CreateAccountPage
import org.gangulwar.expensetracker.IntroPage
import org.gangulwar.expensetracker.LoginPage

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.StartingScreenNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Intro.route,
        route = Graph.AUTHENTICATION
    ) {
        composable(Screen.Intro.route) {
            IntroPage(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginPage(navController = navController)
        }
        composable(Screen.SignUp.route) {
            CreateAccountPage(navController = navController)
        }

//        composable(BottomNavItem.Profile.route) {
//            ProfileScreen()
//        }
//
//        composable(BottomNavItem.NewExpense.route) {
//            NewExpenseScreen()
//        }
    }
}

sealed class Screen(var route: String) {
    object Intro : Screen("intro")
    object Login : Screen("login")
    object SignUp : Screen("sign_up")
}