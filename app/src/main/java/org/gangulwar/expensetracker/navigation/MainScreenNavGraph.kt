package org.gangulwar.expensetracker.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.gangulwar.expensetracker.BottomNavItem
import org.gangulwar.expensetracker.HomeScreen
import org.gangulwar.expensetracker.ListScreen
import org.gangulwar.expensetracker.NewExpenseScreen
import org.gangulwar.expensetracker.ProfileScreen
import org.gangulwar.expensetracker.StatsScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.mainScreenNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = BottomNavItem.Home.route,
        route = "mainScreenRoute"
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.List.route) {
            ListScreen()
        }
        composable(BottomNavItem.Stats.route) {
            StatsScreen()
        }

        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }

        composable(BottomNavItem.NewExpense.route) {
            NewExpenseScreen()
        }
    }
}