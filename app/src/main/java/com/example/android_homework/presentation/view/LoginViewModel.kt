package com.example.android_homework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _log = MutableLiveData<Unit?>()
    val log: LiveData<Unit?> = _log

    private val _reg = MutableLiveData<Unit?>()
    val reg: LiveData<Unit?> = _reg

    private val _recV = MutableLiveData<Unit?>()
    val recV: LiveData<Unit?> = _recV

    fun loginButtonClick(){
        _log.value = Unit
    }

    fun registrationButtonClick(){
        _reg.value = Unit
    }

    fun recyclerViewButtonClick(){
        _recV.value = Unit
    }
}
