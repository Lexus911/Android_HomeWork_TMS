package com.example.android_homework.presentation.view.home

import com.example.android_homework.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val authInteractor: AuthInteractor){
    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment){
        detailsView = detailsFragment
    }

    fun getDetails(title: String?, description: String?, time: String?, imageTitle: Int){
        detailsView.displayDetails(
            when(title.isNullOrEmpty()){
                true -> "NO DATA"
                false -> title},
            when(description.isNullOrEmpty()){
                true -> "NO DATA"
                false -> description},
            when(time.isNullOrEmpty()){
                true -> "NO DATA"
                false -> time},
            imageTitle)
    }

    fun logoutUser(){
        authInteractor.logoutUser()
        detailsView.userLoggedOut()
    }

}