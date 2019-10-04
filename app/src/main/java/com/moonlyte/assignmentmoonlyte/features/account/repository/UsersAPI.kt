package com.moonlyte.assignmentmoonlyte.features.account.repository

import com.moonlyte.assignmentmoonlyte.features.account.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface UsersAPI {

    @GET("/users")
    fun getUsers(): Call<List<Users>>
}