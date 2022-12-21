package com.example.android_homework.domain.auth

import com.example.android_homework.presentation.model.UserModel


interface AuthRepository {
    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds(): UserModel

    fun doesUserExist(): Boolean

    fun userLogout()
}