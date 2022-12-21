package com.example.android_homework.presentation.view.auth

import com.example.android_homework.domain.auth.AuthInteractor

import javax.inject.Inject

class AuthPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    fun loginUser(userName: String, userPassword: String){
        authInteractor.loginUser(userName, userPassword)
    }

    fun showUserData(){
        authInteractor.getUserCreds()
    }

    fun checkUserExists(){
        authInteractor.checkUseerExists()
    }

}