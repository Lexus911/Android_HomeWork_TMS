package com.example.android_homework.presentation.view.auth

interface LoginView {

    fun userLoggedIn()

    fun goToRecyclerView()

    fun buttonPushResult(buttonPush: Boolean)
}