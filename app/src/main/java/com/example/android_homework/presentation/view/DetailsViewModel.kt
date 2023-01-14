package com.example.android_homework.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_homework.R
import com.example.android_homework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {
    private val _details = MutableLiveData<Int?>()
    val details: LiveData<Int?> = _details

    fun logoutUser(){
        viewModelScope.launch {
            try {
                authInteractor.logoutUser()
                _details.value = R.id.loginFragment
            }
            catch (e: Exception){
                Log.w("exception","logout user FAILED")
            }

        }
    }
}