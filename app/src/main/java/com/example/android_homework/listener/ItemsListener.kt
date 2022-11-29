package com.example.android_homework.listener

interface ItemsListener {
    fun onClick()

    fun onElementSelected(imageTitle: Int, title: String, description: String, time: String)
}