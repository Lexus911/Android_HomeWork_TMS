package com.example.android_homework.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.android_homework.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.setView(this)
        mainPresenter.checkUserExists()

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun userExistsResult(userExists: Boolean) {
                when(userExists) {
                    true -> navController.setGraph(R.navigation.main_graph)
                    false -> navController.setGraph(R.navigation.auth_graph)
                }
    }
}