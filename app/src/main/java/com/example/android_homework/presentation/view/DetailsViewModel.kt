package com.example.android_homework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_homework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {
    private val _details = MutableLiveData<Unit?>()
    val details: LiveData<Unit?> = _details

    fun logoutUser(){
        authInteractor.logoutUser()
        _details.value = Unit
    }
}