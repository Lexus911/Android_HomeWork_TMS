package com.example.android_homework.data.sharedpref

import android.content.SharedPreferences
import com.example.android_homework.presentation.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences){
    fun saveUserName(name: String?){
        sharedPreferences.edit().putString("USER_NAME", name).apply()
    }

    fun saveUserPassword(password: String?){
        sharedPreferences.edit().putString("USER_PASSWORD", password).apply()
    }

    fun getUserCreds(): UserModel{
        val name = sharedPreferences.getString(USER_NAME,"") ?: "No user"
        val password = sharedPreferences.getString(USER_PASSWORD,"") ?: "No user"
        return UserModel(name, password)
    }

    fun checkUserExists(): Boolean{
        val name = sharedPreferences.getString(USER_NAME,"")
        val password = sharedPreferences.getString(USER_PASSWORD,"")
        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())
    }

    fun removeUser(){
        saveUserName(null)
        saveUserPassword(null)
        sharedPreferences.edit().putBoolean(BUTTON_PRESSED, false).apply()
    }

    fun buttonPressed(){
        sharedPreferences.edit().putBoolean(BUTTON_PRESSED, true).apply()
    }

    fun checkButtonPush(): Boolean {
        return sharedPreferences.getBoolean(BUTTON_PRESSED, false)
    }

    companion object{
        private const val USER_NAME = "USER_NAME"
        private const val USER_PASSWORD = "USER_PASSWORD"
        private const val BUTTON_PRESSED = "BUTTON_PRESSED"
    }
}