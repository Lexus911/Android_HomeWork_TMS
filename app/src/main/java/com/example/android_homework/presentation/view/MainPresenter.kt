package com.example.android_homework.presentation.view

import com.example.android_homework.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor( private val authInteractor: AuthInteractor){
    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists(){
        val doesUserExists = authInteractor.checkUseerExists()
        mainView.userExistsResult(doesUserExists)
    }
}