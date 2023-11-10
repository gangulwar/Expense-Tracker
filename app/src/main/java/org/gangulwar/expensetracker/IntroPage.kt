package org.gangulwar.expensetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val interFamily = FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold)
)

@Composable
fun IntroPage() {



    val interBold = FontFamily(Font(R.font.inter_bold))

//    Box(
//        modifier = Modifier
//            .background(color = Color(8, 9, 10))
//            .fillMaxSize()
//    ) {
//        Image(
//            modifier = Modifier.fillMaxSize(),
//            painter = painterResource(id = R.drawable.intro_page),
//            contentDescription = null
//        )
//
//
//        Text(
//            text = "Track Your Expenses Easily", style = TextStyle(
////                fontFamily = interBold
//fontFamily = interFamily, fontWeight = FontWeight.Bold, color = Color.White
//            )
//        )
//    }
    Column(
        modifier = Modifier
            .background(color = Color(8, 9, 10))
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            painter = painterResource(id = R.drawable.half_intro_page_bg),
            contentDescription = null, contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(25.dp),
//            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Track Your Expenses Easily", style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White, fontSize = 35.sp
                )
            )

            Text(
                modifier = Modifier.padding(top = 15.dp, bottom = 50.dp),
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = Color(132, 132, 132)
                )
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(175.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(180, 242, 225),
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Get Started", style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Test() {
    IntroPage()
}