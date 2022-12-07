package com.example.android_homework.presentation.adapter.listener

interface ItemsListener {
    fun onClick()

    fun onElementSelected(imageTitle: Int, title: String, description: String, time: String)
}