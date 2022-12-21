package com.example.android_homework.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_homework.R
import com.example.android_homework.presentation.view.auth.AuthPresenter
import com.example.android_homework.presentation.view.auth.LoginFragment
import com.example.android_homework.presentation.view.home.MainScreenFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var authPresenter: AuthPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_container,
            LoginFragment()
        )
        fragmentTransaction.commit()
    }
}