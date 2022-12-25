package com.example.android_homework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(): ViewModel() {
    private val _reg = MutableLiveData<Unit?>()
    val reg: LiveData<Unit?> = _reg


    fun registrationButtonClick(){
        _reg.value = Unit
    }
}