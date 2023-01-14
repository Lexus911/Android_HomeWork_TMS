package com.example.android_homework.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_homework.R
import com.example.android_homework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _nav = MutableLiveData<Int>()
    val nav: LiveData<Int> = _nav

    fun checkUserExists(){
        viewModelScope.launch {
            try {
                val doesUserExist = authInteractor.checkUserExists()
                _nav.value = when(doesUserExist){
                    true -> R.navigation.main_graph
                    false -> R.navigation.auth_graph
                }
            } catch (e: Exception) {
                Log.w("exception", "Check user exist FAILED")
            }
        }
    }
}