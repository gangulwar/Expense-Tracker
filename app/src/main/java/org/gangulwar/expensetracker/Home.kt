package org.gangulwar.expensetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FloatingActionButtonElevation
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import org.gangulwar.expensetracker.BottomNavItem.Home.name
import org.gangulwar.expensetracker.ui.theme.ExpenseTrackerTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationScreen(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.List,
        BottomNavItem.Stats,
        BottomNavItem.Profile,
//        BottomNavItem.NewExpense
    )

    var selected by remember { mutableStateOf(0) }

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(

        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
//            CenterAlignedTopAppBar(
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    titleContentColor = MaterialTheme.colorScheme.primary,
//                ), title = {
//                    Text(text = "")
//
//                }
//            )
            LargeTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.main_bg),
                    titleContentColor = Color.White,
                ),
                title = {
                    Column() {
                        Text(
                            text = "Good Morning", style = TextStyle(
                                color = Color.White,
                                fontSize = 15.sp,
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Bold
                            )
                        )


                        Text(
                            modifier = Modifier.padding(top = 15.dp),
                            text = "Aarsh Gangulwar", style = TextStyle(
                                color = Color.White,
                                fontSize = 25.sp,
                                fontFamily = interFamily,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }

                }, actions = {
                    Image(
                        modifier = Modifier
//                            .background(
//                                color = Color.Black,
//                                shape = CircleShape
//                            )
                            .clip(CircleShape)
                            .size(50.dp),
                        painter = painterResource(R.drawable.user_image),
                        contentDescription = null
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigation(
//                modifier = Modifier.fillMaxWidth().height(117.dp)
//                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                backgroundColor = Color(30, 30, 30),
                modifier = Modifier
                    .padding(5.dp)
                    .height(75.dp)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                items.forEachIndexed { index, item ->
                    val isSelected = index == selected
                    BottomNavigationItem(
                        icon = {
                            val icon = if (isSelected) item.selectedIcon else item.icon
                            Image(
                                painter = painterResource(id = icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 10.dp, top = 10.dp)
                                    .size(35.dp)
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            selected = index
                            navController.navigate(item.route)
                        }, label = {
                            Text(
                                text = item.name, style = TextStyle(
                                    color = Color.White
                                )
                            )

                        }
                    )
                }
            }
        }, floatingActionButtonPosition = FabPosition.End,
//        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                containerColor = Color.Black,
                onClick = {
                    navController.navigate(BottomNavItem.NewExpense.route)
                },
//                elevation = FloatingActionButtonDefaults.elevation(35.dp,35.dp,35.dp,35.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.new_expense),
                    contentDescription = null,
                    Modifier.size(75.dp)
                )
            }
        }


    ) { innerPadding ->
        NavHost(
            navController = navController as NavHostController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
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
}

sealed class BottomNavItem(
    val route: String,
    val name: String,
    val icon: Int,
    val selectedIcon: Int
) {
    object Home : BottomNavItem("home", "Home", R.drawable.nav_home_des, R.drawable.nav_home_sel)
    object List :
        BottomNavItem("favorites", "List", R.drawable.nav_list_des, R.drawable.nav_list_sel)

    object Stats :
        BottomNavItem("cart", "Stats", R.drawable.nav_stats_des, R.drawable.nav_stats_sel)

    object Profile : BottomNavItem(
        "notification",
        "Profile",
        R.drawable.nav_profile_des,
        R.drawable.nav_profile_sel
    )

    object NewExpense :
        BottomNavItem("newExpense", "New Expense", R.drawable.new_expense, R.drawable.new_expense)

}

@Composable
fun HomeScreen() {
    TextView(name = "Home Screen")
}

@Composable
fun ListScreen() {
    TextView(name = "List Screen")
}

@Composable
fun StatsScreen() {
    TextView(name = "Statists Screen")
}

@Composable
fun ProfileScreen() {
    TextView(name = "Profile Screen")
}

@Composable
fun NewExpenseScreen() {
    TextView(name = "New Expense")
}

@Composable
fun TextView(name: String) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is $name", style =
            TextStyle(
                fontSize = 25.sp
            )
        )
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    BottomNavigationScreen(navController)
}

@Preview(
    showBackground = true, showSystemUi = true, name = "Home Screen"
)
@Composable
fun GreePreview() {
    ExpenseTrackerTheme {
        Main()
//        SimpleBottomAppBar()
    }
}
