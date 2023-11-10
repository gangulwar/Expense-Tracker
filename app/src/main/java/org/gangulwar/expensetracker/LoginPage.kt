package org.gangulwar.expensetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage() {

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

        Column(Modifier.padding(15.dp)) {

            Text(
                text = "Sign in", style = TextStyle(
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

            OutlinedTextField(
                value = username,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White
                ),
                onValueChange = {
                         username = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp)
            )


        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage()
}