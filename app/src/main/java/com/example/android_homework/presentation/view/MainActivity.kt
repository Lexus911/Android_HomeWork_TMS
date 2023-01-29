package com.example.android_homework.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android_homework.R
import com.example.android_homework.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView, NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        mainPresenter.setView(this)
        mainPresenter.checkUserExists()

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener(this)
    }

    override fun userExistsResult(userExists: Boolean) {
        when(userExists) {
            true -> navController.setGraph(R.navigation.main_graph)
            false -> navController.setGraph(R.navigation.auth_graph)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        if(destination.id == R.id.loginFragment) {
            binding.bottomNavigation.visibility = VISIBLE
        } else {
            binding.bottomNavigation.visibility = GONE
        }
    }
}