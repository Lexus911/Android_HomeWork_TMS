package com.example.android_homework.presentation.adapter.listener

interface ItemsListener {
    fun onElementSelected(imageTitle: Int, title: String, description: String, time: String)
}