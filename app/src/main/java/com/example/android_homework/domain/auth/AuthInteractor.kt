package com.example.android_homework.domain.auth


import com.example.android_homework.presentation.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {

    fun loginUser(userName: String, userPassword: String){
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    fun checkUseerExists(): Boolean{
        return authRepository.doesUserExist()
    }

    fun logoutUser(){
        authRepository.userLogout()
    }

    fun buttonPressed(){
        authRepository.buttonPressed()
    }

    fun checkButtonPush(): Boolean{
       return authRepository.checkButtonPush()
    }
}