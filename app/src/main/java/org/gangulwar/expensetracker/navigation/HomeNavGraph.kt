package org.gangulwar.expensetracker.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.gangulwar.expensetracker.BottomNavItem
import org.gangulwar.expensetracker.HomeScreen
import org.gangulwar.expensetracker.ListScreen
import org.gangulwar.expensetracker.NewExpenseScreen
import org.gangulwar.expensetracker.ProfileScreen
import org.gangulwar.expensetracker.StatsScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(route = BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavItem.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomNavItem.List.route) {
           ListScreen()
        }
        composable(route = BottomNavItem.Stats.route) {
            StatsScreen()
        }
        composable(route = BottomNavItem.NewExpense.route) {
            NewExpenseScreen()
        }
        //detailsNavGraph(navController = navController)
    }
}