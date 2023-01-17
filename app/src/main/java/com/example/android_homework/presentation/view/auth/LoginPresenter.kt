package com.example.android_homework.presentation.view.auth

import android.util.Log
import com.example.android_homework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authInteractor: AuthInteractor) {
    lateinit var loginView: LoginView

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("Login exceptionHandlerCalled", exception.toString())
    }

    fun setView(loginFragment: LoginFragment){
        loginView = loginFragment
    }

    fun loginUser(userName: String, userPassword: String){

        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    authInteractor.loginUser(userName, userPassword)
                    loginView.userLoggedIn()
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","loginUser FAILED")
            }
        }
    }

    fun goToRecyclerView(){
        loginView.goToRecyclerView()
    }

    fun goToRegistration(){

        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    val isButtonPushed = authInteractor.checkButtonPush()
                    loginView.buttonPushResult(isButtonPushed)
                    authInteractor.buttonPressed()
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","Go to registration FAILED")
            }
        }
    }
}