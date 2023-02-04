package com.example.android_homework.domain.auth

import com.example.android_homework.presentation.model.UserModel
import com.example.android_homework.presentation.model.UsersModel


interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend fun userLogout()

    suspend fun buttonPressed()

    suspend fun checkButtonPush(): Boolean

    suspend fun registerUser(usersModel: UsersModel)

    suspend fun showUsers(): List<UsersModel>
}