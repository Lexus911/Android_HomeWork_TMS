package com.example.android_homework.presentation.view.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.android_homework.R

object Navigator {

    fun replace(
    parentFragmentManager: FragmentManager,
    fragment: Fragment,
    addToBackStack: Boolean){
        if(addToBackStack){
            parentFragmentManager
            .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .addToBackStack(null)
                .commit()
        }else {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .commit()
        }
    }

    fun add(
        parentFragmentManager: FragmentManager,
        fragment: Fragment,
        addToBackStack: Boolean){
        if(addToBackStack){
            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, fragment)
                .addToBackStack(null)
                .commit()
        }else {
            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, fragment)
                .commit()
        }
    }
}