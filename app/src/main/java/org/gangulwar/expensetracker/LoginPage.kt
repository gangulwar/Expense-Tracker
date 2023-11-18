package org.gangulwar.expensetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {

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

            var username by remember { mutableStateOf(TextFieldValue("username")) }

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

            var password by remember { mutableStateOf(TextFieldValue("password")) }

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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(rememberNavController())
}