package com.example.android_homework.data.auth

import android.util.Log
import com.example.android_homework.data.database.UsersEntity
import com.example.android_homework.data.database.dao.ItemsDAO
import com.example.android_homework.data.sharedpref.SharedPreferencesHelper
import com.example.android_homework.domain.auth.AuthRepository
import com.example.android_homework.presentation.model.UserModel
import com.example.android_homework.presentation.model.UsersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val itemsDAO: ItemsDAO
    ): AuthRepository {

    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {

        return  withContext(Dispatchers.IO) { sharedPreferencesHelper.getUserCreds() }
    }

    override suspend fun doesUserExist(): Boolean {
        return  withContext(Dispatchers.IO) { sharedPreferencesHelper.checkUserExists() }
    }

    override suspend fun userLogout() {
        return  withContext(Dispatchers.IO) { sharedPreferencesHelper.removeUser() }
    }

    override suspend fun buttonPressed() {
        return  withContext(Dispatchers.IO) { sharedPreferencesHelper.buttonPressed() }
    }

    override suspend fun checkButtonPush(): Boolean {
        return  withContext(Dispatchers.IO) { sharedPreferencesHelper.checkButtonPush() }
    }

    override suspend fun registerUser(usersModel: UsersModel) {
        withContext(Dispatchers.IO) {
            itemsDAO.insertUsersEntity(
                UsersEntity(
                    usersModel.id,
                    usersModel.name,
                    usersModel.username,
                    usersModel.email,
                    usersModel.password
                )
            )
            Log.w("exception","registration add to DB")
        }
    }

    override suspend fun showUsers(): List<UsersModel> {
        return withContext(Dispatchers.IO) {
            val usersEntity = itemsDAO.getUsersEntities()
                usersEntity.map {
                    UsersModel(
                        it.id,
                        it.name,
                        it.username,
                        it.email,
                        it.password
                    )
            }
        }
    }
}