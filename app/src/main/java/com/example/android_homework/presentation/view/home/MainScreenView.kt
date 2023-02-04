package com.example.android_homework.presentation.view.home

import com.example.android_homework.presentation.model.UsersModel

interface MainScreenView {

    fun getUserName(userName: String, userPassword: String)

    fun getUsersData(usersData: List<UsersModel>)

    fun backToLogin()
}