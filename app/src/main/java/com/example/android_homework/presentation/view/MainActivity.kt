package com.example.android_homework.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.android_homework.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.checkUserExists()

        viewModel.userExists.observe(this) {
          supportFragmentManager.beginTransaction()
            .add(
                R.id.activity_container,
                when (it) {
                    true -> MainScreenFragment()
                    false -> LoginFragment()
                }
            )
            .commit()
        }
    }
}