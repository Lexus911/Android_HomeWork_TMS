package com.example.android_homework.domain.auth

import com.example.android_homework.presentation.model.UserModel

interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend fun userLogout()
}