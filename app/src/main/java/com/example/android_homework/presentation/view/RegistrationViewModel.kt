package com.example.android_homework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_homework.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(): ViewModel() {
    private val _reg = MutableLiveData<Int?>()
    val reg: LiveData<Int?> = _reg


    fun registrationButtonClick(){
        _reg.value = R.navigation.main_graph
    }
}