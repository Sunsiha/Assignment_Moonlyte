package com.moonlyte.assignmentmoonlyte.features.account

import androidx.lifecycle.ViewModel
import com.moonlyte.assignmentmoonlyte.features.account.model.Users
import com.moonlyte.assignmentmoonlyte.features.account.model.UsersModel
import com.moonlyte.assignmentmoonlyte.features.account.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel : ViewModel() {

    private val usersModel = UsersModel()
    private val userRepository = UserRepository()

    fun loadUsers() {
        this.userRepository.getUsers().enqueue(object : Callback<List<Users>> {
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    usersModel.userList = response.body()!!
                }
            }

        })
    }

    fun getUsersModel(): UsersModel {
        return this.usersModel
    }
}
