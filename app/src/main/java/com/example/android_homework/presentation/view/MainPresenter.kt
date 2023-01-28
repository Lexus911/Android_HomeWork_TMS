package com.example.android_homework.presentation.view

import android.util.Log
import com.example.android_homework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(private val authInteractor: AuthInteractor) {
    private lateinit var mainView: MainView
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.w("exceptionHandlerCalled", exception.toString())
    }

    fun setView(mainActivity: MainActivity) {
        mainView = mainActivity
    }

    fun checkUserExists() {
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    val doesUserExists = authInteractor.checkUseerExists()
                    mainView.userExistsResult(doesUserExists)
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception", "Check user exist FAILED")
            }
        }
    }
}