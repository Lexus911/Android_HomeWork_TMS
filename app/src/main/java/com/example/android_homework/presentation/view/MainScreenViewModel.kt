package com.example.android_homework.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_homework.domain.auth.AuthInteractor
import com.example.android_homework.presentation.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private val _dialog = MutableLiveData<UserModel>()
    val dialog: LiveData<UserModel> = _dialog

    fun showDialog(){
        viewModelScope.launch {
            try {
                _dialog.value = authInteractor.getUserCreds()
            }catch (e: Exception){
                Log.w("exception","Login from main screen FAILED")
            }
        }
    }


}