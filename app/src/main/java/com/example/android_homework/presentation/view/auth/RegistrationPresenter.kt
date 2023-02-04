package com.example.android_homework.presentation.view.auth


import android.util.Log
import com.example.android_homework.domain.auth.AuthInteractor
import com.example.android_homework.presentation.model.UsersModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationPresenter @Inject constructor(private val authInteractor: AuthInteractor){
    lateinit var registrationView: RegistrationView
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("Login exceptionHandlerCalled", exception.toString())
    }

    fun setView(registrationFragment: RegistrationFragment){
        registrationView = registrationFragment
    }

    fun registerUser(usersModel: UsersModel){

        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    authInteractor.registerUser(usersModel)
                    registrationView.userRegisteredIn()
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","registration FAILED")
            }
        }

    }
}