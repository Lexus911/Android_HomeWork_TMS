package com.example.android_homework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {
    private val _dialog = MutableLiveData<Unit?>()
    val dialog: LiveData<Unit?> = _dialog

    fun showDialog(){
        _dialog.value = Unit
    }

}