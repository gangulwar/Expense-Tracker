package org.gangulwar.expensetracker

sealed class Screen(var route:String){
    object Intro:Screen("intro")
    object Login:Screen("login")
    object SignUp:Screen("sign_up")
    object Home:Screen("home")
}
