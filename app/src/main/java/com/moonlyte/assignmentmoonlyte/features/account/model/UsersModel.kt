package com.moonlyte.assignmentmoonlyte.features.account.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.moonlyte.assignmentmoonlyte.BR

class UsersModel : BaseObservable() {

    @get: Bindable
    var userList: List<Users> = emptyList()
    set(value) {
        field = value
        notifyPropertyChanged(BR.userList)
    }
}