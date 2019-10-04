package com.moonlyte.assignmentmoonlyte.features.account

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.moonlyte.assignmentmoonlyte.R
import com.moonlyte.assignmentmoonlyte.databinding.ActivityUsersBinding
import com.moonlyte.assignmentmoonlyte.features.account.adapter.UsersAdapter

class UsersActivity : AppCompatActivity() {

    private val usersViewModel: UsersViewModel by lazy {
        ViewModelProviders.of(this).get(UsersViewModel::class.java)
    }

   private lateinit var activityUsersBinding: ActivityUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityUsersBinding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        activityUsersBinding.viewModel = this.usersViewModel

        val usersAdapter = UsersAdapter()
        activityUsersBinding.adapter = usersAdapter

        this.usersViewModel.loadUsers()
    }
}
