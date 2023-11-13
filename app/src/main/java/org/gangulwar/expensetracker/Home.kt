package org.gangulwar.expensetracker

import android.os.Build
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
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
import org.gangulwar.expensetracker.modal.TransactionModal
import org.gangulwar.expensetracker.ui.theme.ExpenseTrackerTheme
import java.nio.file.WatchEvent
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit


@RequiresApi(Build.VERSION_CODES.O)
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
            TopAppBar(
                modifier = Modifier.height(100.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.main_bg),
                    titleContentColor = Color.Transparent,
                ),
                title = {
                    Column(
                        Modifier
                            .fillMaxHeight()
                            .padding(start = 20.dp, top = 10.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Good Morning", style = TextStyle(
                                color = Color.White,
                                fontSize = 15.sp,
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Aarsh Gangulwar", style = TextStyle(
                                color = Color.White,
                                fontSize = 25.sp,
                                fontFamily = jostFamily,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }

                }, actions = {
                    Image(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 10.dp)
//
//                            .background(
//                                color = Color.White,
//                                shape = CircleShape
//                            )
                            .clip(CircleShape)
                            .size(50.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(R.drawable.demo_user),
                        contentDescription = null,
//                        contentScale = ContentScale.FillBounds
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
                    .background(colorResource(id = R.color.card), RoundedCornerShape(0.dp))
                    .padding(5.dp)
                    .height(75.dp)
//                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.main_bg))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75f)

        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.bg_lines),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 25.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Budget Balance",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 15.sp
                    )
                )
                val amount = 5000
                Text(
                    text = "₹${amount}",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 55.sp
                    )
                )
            }
        }

        var isIncomeChecked by remember {
            mutableStateOf(true)
        }

        Card(
            modifier = Modifier
                .fillMaxSize()
                .weight(2f),
//                .verticalScroll(rememberScrollState()),
            shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
//                        color = Color(192, 192, 192, 255)
                        colorResource(id = R.color.card)
                    )
                    .padding(top = 10.dp, start = 15.dp, end = 15.dp)
            )
            {
//                ToggleButton(isIncomeChecked) { updateValue ->
//                    isIncomeChecked = updateValue
//                }


                CustomToggleButton(isIncomeChecked = isIncomeChecked,
                    isChecked = {
                        isIncomeChecked = it
                    }
                )

                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Recents", style = TextStyle(
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp,
                        color = Color.Black
                    )
                )

                val list = ApiRepository.getRecentsIncomeList()
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),  // Occupy remaining space
                    contentPadding = PaddingValues(bottom = 16.dp)  // Add some bottom padding
                ) {
                    items(list) { transaction ->
                        TransactionItem(transaction = transaction)
                    }
                }
            }
//            Box(modifier = Modifier.)

        }
    }
}
//Transaction Modal

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TransactionItem(transaction: TransactionModal) {
    val category = transaction.category
    val description = transaction.description
    val dateTime = formatDateTime(transaction.dateTime)
    val amount = transaction.amount
    var image: Painter? = null
    if (category == "Transportation") {
        image = painterResource(id = R.drawable.transportation)
    } else if (category == "Food") {
        image = painterResource(id = R.drawable.food)
    } else if (category == "Health") {
        image = painterResource(id = R.drawable.health_and_wellness)
    } else if (category == "Grocery") {
        image = painterResource(id = R.drawable.grocery)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (image != null) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .weight(0.75f),
                painter = image, contentDescription = null,

                )
        }
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(2f)
        ) {
            Text(
                text = category, style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            )

            Text(
                text = dateTime, style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp
                )
            )

            Text(
                text = description, style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            )
        }
        Text(
            modifier = Modifier.weight(1f),
            text = "₹ ${amount.toString()}", style = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp
            )
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateTime(dateTime: LocalDateTime): String {
    val now = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm")

    return when {
        dateTime.toLocalDate().isEqual(now.toLocalDate()) -> "Today, ${dateTime.format(formatter)}"
        dateTime.toLocalDate()
            .isEqual(now.toLocalDate().minus(1, ChronoUnit.DAYS)) -> "Yesterday, ${
            dateTime.format(
                formatter
            )
        }"

        else -> dateTime.format(DateTimeFormatter.ofPattern("MMM d, HH:mm"))
    }
}

@Composable
fun CustomToggleButton(
    isIncomeChecked: Boolean,
    isChecked: (Boolean) -> Unit,
    wantRed: Boolean = false
) {

//    var isIncomeChecked by remember {
//        mutableStateOf(true)
//    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.Center

    ) {

        Button(

            onClick = { isChecked(true) },
            shape = RoundedCornerShape(
                topStart = 25.dp,
                bottomStart = 25.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor =
                if (wantRed) {
                    if (isIncomeChecked) {
                        colorResource(id = R.color.checked_green)
                    } else {
                        Color.Black
                    }
                } else {
                    if (isIncomeChecked) {
                        Color.Black
                    } else {
                        Color.White
                    }
                }
            )
        ) {
            Text(
                //modifier = Modifier.background(),

                text = "Income", style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    color =
                    if (wantRed) {
                        Color.White
                    } else {
                        if (isIncomeChecked) {
                            Color.Black
                        } else {
                            Color.White
                        }
                    }

                )
            )
        }

        Button(

            onClick = { isChecked(false) },
            shape = RoundedCornerShape(
                topEnd = 25.dp,
                bottomEnd = 25.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor =
                if (wantRed) {
                    if (isIncomeChecked) {
                        Color.Black
                    } else {
                        colorResource(id = R.color.checked_red)
                    }
                } else {
                    if (isIncomeChecked) {
                        Color.Black
                    } else {
                        Color.White
                    }
                }
            )
        ) {
            Text(
                //modifier = Modifier.background(),

                text = "Expense", style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    color =
                    if (wantRed) {
                        Color.White
                    } else {
                        if (isIncomeChecked) {
                            Color.Black
                        } else {
                            Color.White
                        }
                    }
                )
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListScreen() {

    var isChecked by remember {
        mutableStateOf(true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.card)
            )
            .padding(top = 15.dp, start = 15.dp)
    ) {
        Column() {
            Text(
                text = "All Transactions ", style =
                TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color = Color.Black
                )
            )
            CustomToggleButton(
                isIncomeChecked = isChecked, isChecked = {
                    isChecked = it
                }, wantRed = true
            )

            var list: List<TransactionModal>? = null
            if (isChecked) {
                list = ApiRepository.getIncomeList()
            } else {
                list = ApiRepository.getExpenseList()
            }

            LazyColumn() {
                items(list) { transaction ->
                    TransactionItem(transaction = transaction)
                }
            }
        }
    }
}

@Composable
fun StatsScreen() {
    TextView(name = "Statists Screen")
}

@Composable
fun ProfileScreen() {
    TextView(name = "Profile Screen")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewExpenseScreen() {

    var amount by remember {
        mutableStateOf("Enter Amount")
    }

    var description by remember {
        mutableStateOf("Enter Description")
    }

    var incomeSeleted by remember {
        mutableStateOf(true)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
//                modifier = Modifier.fillMaxWidth(),
                text = "New Expense", style =
                TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color = Color.Black
                )
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(Color.Black)
            )

            Row(
                modifier = Modifier.padding(15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rupee_icon),
                    contentDescription = null
                )

                TextField(
                    modifier = Modifier.padding(start = 10.dp),
                    value = "Enter Amount",
                    onValueChange = {
                        amount = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Black
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp
                    )
                )
            }

            Row(
                modifier = Modifier.padding(15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.description_icon),
                    contentDescription = null
                )

                TextField(
                    modifier = Modifier.padding(start = 10.dp),
                    value = "Enter a description",
                    onValueChange = {
                        description = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Black
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                )
            }

            CustomToggleButton(
                isIncomeChecked = incomeSeleted,
                isChecked = {
                    incomeSeleted = it
                },
                wantRed = true
            )
        }
    }
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Main() {
    val navController = rememberNavController()
    BottomNavigationScreen(navController)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true, showSystemUi = true, name = "Home Screen"
)
@Composable
fun GreePreview() {
    ExpenseTrackerTheme {
        //Main()
//        SimpleBottomAppBar()
        //HomeScreen()
        // ListScreen()
        NewExpenseScreen()
    }
}
