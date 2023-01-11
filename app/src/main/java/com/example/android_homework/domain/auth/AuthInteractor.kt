package com.example.android_homework.domain.auth


import com.example.android_homework.presentation.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {

    suspend fun loginUser(userName: String, userPassword: String){
        authRepository.loginUser(userName, userPassword)
    }

    suspend fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    suspend fun checkUseerExists(): Boolean{
        return authRepository.doesUserExist()
    }

    suspend fun logoutUser(){
        authRepository.userLogout()
    }

    suspend fun buttonPressed(){
        authRepository.buttonPressed()
    }

    suspend fun checkButtonPush(): Boolean{
       return authRepository.checkButtonPush()
    }
}