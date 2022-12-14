package com.example.android_homework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainScreenViewModel : ViewModel() {
    private val _dialog = MutableLiveData<Unit?>()
    val dialog: LiveData<Unit?> = _dialog

    fun showDialog(){
        _dialog.value = Unit
    }

}