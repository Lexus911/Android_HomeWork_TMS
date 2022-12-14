package com.example.android_homework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    private val _details = MutableLiveData<Unit?>()
    val details: LiveData<Unit?> = _details

    fun showDetails(){
        _details.value = Unit
    }
}