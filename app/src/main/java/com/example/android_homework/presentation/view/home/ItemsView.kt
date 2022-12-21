package com.example.android_homework.presentation.view.home

import com.example.android_homework.presentation.model.ItemsModel

interface ItemsView {

    fun dataReceived (list: List<ItemsModel>)

    fun goToDetails(imageTitle: Int, title: String, description: String, time: String)
}