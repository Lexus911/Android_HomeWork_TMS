package com.example.android_homework.presentation.view.home

import com.example.android_homework.domain.auth.AuthInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(private val authInteractor: AuthInteractor) {
    private lateinit var mainScreenView: MainScreenView

    fun setView(mainScreenFragment: MainScreenFragment) {
        mainScreenView = mainScreenFragment
    }

    fun getUserName(){
        val userName = authInteractor.getUserCreds()
        mainScreenView.getUserName(userName)
    }
}