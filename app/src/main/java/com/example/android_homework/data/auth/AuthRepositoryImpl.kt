package com.example.android_homework.data.auth

import com.example.android_homework.data.sharedprefences.SharedPreferencesHelper
import com.example.android_homework.domain.auth.AuthRepository
import com.example.android_homework.presentation.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val sharedPreferencesHelper: SharedPreferencesHelper): AuthRepository{
    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {
        return withContext(Dispatchers.IO){sharedPreferencesHelper.getUserCreads()}
    }

    override suspend fun doesUserExist(): Boolean {
      return withContext(Dispatchers.IO){sharedPreferencesHelper.checkUserExists()}
    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.removeUser()
        }
    }

}