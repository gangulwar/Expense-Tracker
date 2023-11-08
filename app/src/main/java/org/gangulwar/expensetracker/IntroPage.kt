package org.gangulwar.expensetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
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

@Composable
fun IntroPage() {

    val interFamily = FontFamily(
        Font(R.font.inter_bold, FontWeight.Bold),
        Font(R.font.inter_regular, FontWeight.Normal),
        Font(R.font.inter_medium, FontWeight.Medium),
        Font(R.font.inter_extrabold, FontWeight.ExtraBold)
    )

    val interBold = FontFamily(Font(R.font.inter_bold))

    Box(
        modifier = Modifier
            .background(color = Color(8, 9, 10))
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.intro_page),
            contentDescription = null
        )


        Text(
            text = "Track Your Expenses Easily", style = TextStyle(
                fontFamily = interBold
            )
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Test() {
    IntroPage()
}