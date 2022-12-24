package com.example.android_homework.presentation.view.home

interface DetailsView {

    fun userLoggedOut()

    fun displayDetails(title: String, description: String, time: String, imageTitle: Int)
}