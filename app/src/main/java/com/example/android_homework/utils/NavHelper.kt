package com.example.android_homework.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


object NavHelper {


    fun Fragment.navigate(destinationId: Int){
        findNavController().navigate(destinationId)
    }

    fun Fragment.setGraph(graphId: Int){
        findNavController().setGraph(graphId)
    }


    fun Fragment.navigateWithBundle(destinationId: Int, bundle: Bundle){
        findNavController().navigate(destinationId, bundle)
    }


}