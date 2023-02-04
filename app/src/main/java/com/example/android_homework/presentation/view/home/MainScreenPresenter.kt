package com.example.android_homework.presentation.view.home

import android.util.Log
import com.example.android_homework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(private val authInteractor: AuthInteractor) {
    private lateinit var mainScreenView: MainScreenView

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("exceptionHandlerCalled", exception.toString())
    }

    fun setView(mainScreenFragment: MainScreenFragment) {
        mainScreenView = mainScreenFragment
    }

    fun showUserName(){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {

                    val userName = authInteractor.getUserCreds().userName
                    val userPassword = authInteractor.getUserCreds().userPassword
                    val usersData = authInteractor.showUsers()

                    mainScreenView.getUserName(userName, userPassword)

                    mainScreenView.getUsersData(usersData)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","Show user FAILED")
            }
        }
    }

    fun backToLogin(){
        mainScreenView.backToLogin()
    }
}