package com.example.android_homework.presentation.view.auth


import javax.inject.Inject

class RegistrationPresenter @Inject constructor(){
    lateinit var registrationView: RegistrationView

    fun setView(registrationFragment: RegistrationFragment){
        registrationView = registrationFragment
    }

    fun registerUser(){
        registrationView.registerUser()
    }


}