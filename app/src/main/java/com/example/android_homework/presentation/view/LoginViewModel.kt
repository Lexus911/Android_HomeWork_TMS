package com.example.android_homework.presentation.view


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_homework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor): ViewModel() {
    private val _log = MutableLiveData<Unit?>()
    val log: LiveData<Unit?> = _log

    fun loginUser(userName: String, userPassword: String){
        viewModelScope.launch {
            try {
                authInteractor.loginUser(userName, userPassword)
                _log.value = Unit
            }
            catch (e: Exception){
                Log.w("exception","loginUser FAILED")
            }
        }
    }


}
