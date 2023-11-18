package org.gangulwar.expensetracker.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface UserService{

    @GET
    fun getMessages(@Url anotherUrl: String): Call<String>
}