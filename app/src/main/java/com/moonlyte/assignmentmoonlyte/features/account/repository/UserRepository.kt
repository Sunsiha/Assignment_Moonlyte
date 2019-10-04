package com.moonlyte.assignmentmoonlyte.features.account.repository

import com.moonlyte.assignmentmoonlyte.features.account.model.Users
import com.moonlyte.assignmentmoonlyte.network.ApiClient
import retrofit2.Call

class UserRepository {

    private var api: UsersAPI = ApiClient.getApiClient().create(UsersAPI::class.java)

    fun getUsers(): Call<List<Users>> {
        return api.getUsers()
    }
}