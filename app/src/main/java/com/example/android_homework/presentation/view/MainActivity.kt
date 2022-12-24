package com.example.android_homework.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_homework.R
import com.example.android_homework.presentation.view.auth.LoginFragment
import com.example.android_homework.presentation.view.home.MainScreenFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.setView(this)
        mainPresenter.checkUserExists()

    }

    override fun userExistsResult(userExists: Boolean) {
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_container,
                when(userExists) {
                    true -> MainScreenFragment()
                    false -> LoginFragment() })
            .commit()
    }
}