package com.example.android_homework.presentation.view.home

import android.util.Log
import com.example.android_homework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val authInteractor: AuthInteractor){
    private lateinit var detailsView: DetailsView
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("exceptionHandlerCalled", exception.toString())
    }

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
        CoroutineScope(coroutineExceptionHandler + Dispatchers.IO).launch {
            try {
                val job = launch {
                    authInteractor.logoutUser()
                    detailsView.userLoggedOut()
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","logout user FAILED")
            }
        }
    }

}