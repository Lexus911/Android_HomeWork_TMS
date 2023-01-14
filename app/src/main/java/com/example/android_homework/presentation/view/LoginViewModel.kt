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
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor): ViewModel() {
    private val _log = MutableLiveData<Int?>()
    val log: LiveData<Int?> = _log

    private val _recV = MutableLiveData<Int?>()
    val recV: LiveData<Int?> = _recV

    private val _reg = MutableLiveData<Int?>()
    val reg: LiveData<Int?> = _reg



    fun loginUser(userName: String, userPassword: String){
        viewModelScope.launch {
            try {
                authInteractor.loginUser(userName, userPassword)
                _log.value = R.navigation.main_graph
            }
            catch (e: Exception){
                Log.w("exception","loginUser FAILED")
            }
        }
    }

    fun toRecyclerView(){
        _recV.value = R.id.action_loginFragment_to_itemsFragment
    }
    fun toRegistration(){
        _reg.value = R.id.action_loginFragment_to_registrationFragment
    }

    fun userNavigatedRecV(){
        _recV.value = null
    }

    fun userNavigatedReg(){
        _reg.value = null
    }

}
