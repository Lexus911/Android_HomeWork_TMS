package com.example.android_homework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel() {
    private val _reg = MutableLiveData<Unit?>()
    val reg: LiveData<Unit?> = _reg


    fun registrationButtonClick(){
        _reg.value = Unit
    }
}