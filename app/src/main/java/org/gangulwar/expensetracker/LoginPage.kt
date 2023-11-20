package org.gangulwar.expensetracker

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.remember
import androidx.compose.runtime.currentComposer
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.gangulwar.expensetracker.navigation.Graph
import org.gangulwar.expensetracker.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {

    val coroutineScope = rememberCoroutineScope()

    var username by remember { mutableStateOf(TextFieldValue("username")) }
    var password by remember { mutableStateOf(TextFieldValue("password")) }
    var loginResult by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.main_bg))
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(
                id = R.drawable.login_illustration
            ), contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        Column(
            Modifier
                .padding(start = 35.dp, end = 35.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "Login", style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 35.sp
                )
            )

            Text(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                text = "Please sign in to continue", style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontSize = 20.sp
                )
            )


//            OutlinedTextField(
//                modifier = Modifier
//                    .padding(top = 15.dp)
//                    .fillMaxWidth(),
//                value = username,
//                textStyle = TextStyle(
//                    fontSize = 20.sp,
//                    color = Color.White
//                ),
//                onValueChange = {
//                    username = it
//                },
//                colors = TextFieldDefaults.textFieldColors(
//                    containerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.White,
//                    unfocusedIndicatorColor = Color.White
//                ),
//                shape = RoundedCornerShape(15.dp)
//            )

            InputTextField(
                variable = username,
                onValueChange = {
                    username = it
                }
            )


            InputTextField(
                variable = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation()
            )
//            OutlinedTextField(
//                modifier = Modifier
//                    .padding(top = 15.dp)
//                    .fillMaxWidth(),
//                value = password,
//                textStyle = TextStyle(
//                    fontSize = 20.sp,
//                    color = Color.White
//                ),
//                onValueChange = {
//                    password = it
//                },
//                colors = TextFieldDefaults.textFieldColors(
//                    containerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.White,
//                    unfocusedIndicatorColor = Color.White
//                ),
//                shape = RoundedCornerShape(15.dp),
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = KeyboardType.Password
//                )
//            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                //   verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
//                        ApiRepository.login("temp","", coroutineScope)
//                        navController.navigate(Screen.Home.route)
                        /*
                                                coroutineScope.launch(Dispatchers.IO) {
                                                    // Simulate API request, replace with your actual API call
                                                    delay(2000)
                                                    loginResult = ApiRepository.login(
                                                        username = username.text, password = password.text
                                                    )
                                                    // Replace with your API response logic
                                                    withContext(Dispatchers.Main) {
                                                        // Use withContext to switch back to the main thread before updating UI
                        //                                handleLoginResult(apiResult, navController)
                        //                                if (apiResult) {
                        //                                    loginSuccessful(navController)
                        //                                }
                                                    }



                                                }

                                                      navController.navigate(Graph.HOME)
                        */
                        coroutineScope.launch {
                            loginResult= ApiRepository.login(username.text, password.text)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(
                            R.color.login_button
                        )
                    ), shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "LOGIN",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Forgot Password?",
                    style = TextStyle(
                        color = colorResource(R.color.forgot_password),
                        fontSize = 15.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Row(
                    modifier = Modifier.padding(top = 35.dp)
                ) {
                    Text(
                        text = "Dont’t have an account?",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = interFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .clickable {
                                navController.navigate(Screen.SignUp.route)
                            },
                        text = "Sign Up",
                        style = TextStyle(
                            color = colorResource(R.color.forgot_password),
                            fontSize = 15.sp,
                            fontFamily = interFamily,
                            fontWeight = FontWeight.SemiBold
                        ),
                    )
                }
            }
        }
    }

    if (loginResult) {
        loginSuccessful(navController = navController)
        loginResult=false
    }
}

@Composable
fun loginSuccessful(navController: NavHostController) {
    val context = LocalContext.current
    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
//    navController
//        .navigate("mainScreenRoute") {
//            popUpTo(navController.graph.findStartDestination().id)
////                inclusive=true
//            launchSingleTop=true
//
//        }
//    navController.popBackStack()
    navController.navigate(Graph.HOME){
        popUpTo(BottomNavItem.Home.route){
            inclusive=true
        }
    }
    println("Home Reached!")
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    variable: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth(),
        value = variable,
        textStyle = TextStyle(
            fontSize = 20.sp,
            color = Color.White
        ),
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White
        ),
        shape = RoundedCornerShape(15.dp),
        visualTransformation = visualTransformation
    )
}

@Composable
fun showToast(scope: CoroutineScope, message: String) {
//    scope.launch {
    // Use the coroutineScope to launch a coroutine
    // that can interact with the UI thread
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()
//    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(rememberNavController())
}