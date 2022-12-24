package com.example.android_homework.presentation.view.home

import javax.inject.Inject

class NestedPresenter @Inject constructor() {
    private lateinit var nestedView: NestedView

    fun setView(nestedFragment: NestedFragment) {
        nestedView = nestedFragment
    }

    fun backToLogin(){
        nestedView.backToLogin()
    }
}