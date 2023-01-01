package com.example.android_homework.data.auth

import com.example.android_homework.data.sharedpref.SharedPreferencesHelper
import com.example.android_homework.domain.auth.AuthRepository
import com.example.android_homework.presentation.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val sharedPreferencesHelper: SharedPreferencesHelper): AuthRepository {
    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override fun userLogout() {
        return sharedPreferencesHelper.removeUser()
    }

    override fun buttonPressed() {
        return sharedPreferencesHelper.buttonPressed()
    }

    override fun checkButtonPush(): Boolean {
        return sharedPreferencesHelper.checkButtonPush()
    }
}