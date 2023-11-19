package org.gangulwar.expensetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun CreateAccountPage(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.main_bg)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.login_illustration),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alpha = 0.1f
//            alignment = Alignment(Alignment.CenterHorizontally)
        )

        Column(
            modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = stringResource(R.string.create_account),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 35.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                modifier = Modifier.padding(
                    top = 25.dp,
                    bottom = 15.dp
                ),
                text = stringResource(R.string.fill_all_details),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Normal
                )
            )

            var email_id by remember { mutableStateOf(TextFieldValue("email id")) }
            //var password by remember { mutableStateOf(TextFieldValue("password")) }
            var username by remember { mutableStateOf(TextFieldValue("username")) }
            var password by remember { mutableStateOf(TextFieldValue("password")) }
            var confirm_password by remember { mutableStateOf(TextFieldValue("password")) }

            InputTextField(
                variable = email_id,
                onValueChange = {
                    email_id = it
                }
            )
            InputTextField(
                variable = username,
                onValueChange = {
                    username = it
                }
            )
            InputTextField(
                variable = password,
                onValueChange = {
                    password = it
                },
                visualTransformation = PasswordVisualTransformation()
            )
            InputTextField(
                variable = confirm_password,
                onValueChange = {
                    confirm_password = it
                },
                visualTransformation = PasswordVisualTransformation()
            )

            Button(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(
                        R.color.login_button
                    )
                ),
                shape = RoundedCornerShape(15.dp),

                ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = stringResource(R.string.sign_up),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                androidx.compose.material.Text(
                    text = "Dont’t have an account?",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = stringResource(R.string.sign_up),
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CreateAccountPagePreview() {
    CreateAccountPage(rememberNavController())
}