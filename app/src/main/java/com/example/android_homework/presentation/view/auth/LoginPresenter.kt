package com.example.android_homework.presentation.view.auth

import com.example.android_homework.domain.auth.AuthInteractor

import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authInteractor: AuthInteractor) {
    lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment){
        loginView = loginFragment
    }

    fun loginUser(userName: String, userPassword: String){
        authInteractor.loginUser(userName, userPassword)
        loginView.userLoggedIn()
    }


    fun goToRecyclerView(){
        loginView.goToRecyclerView()
    }

    fun goToRegistration(){
        val isButtonPushed = authInteractor.checkButtonPush()
        loginView.buttonPushResult(isButtonPushed)
        authInteractor.buttonPressed()
    }


}