package com.example.android_homework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_homework.domain.auth.AuthInteractor
import com.example.android_homework.presentation.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private val _dialog = MutableLiveData<UserModel>()
    val dialog: LiveData<UserModel> = _dialog

    fun showDialog(){
        _dialog.value = authInteractor.getUserCreds()
    }

}