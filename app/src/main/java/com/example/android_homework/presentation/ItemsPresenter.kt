package com.example.android_homework.presentation

import com.example.android_homework.domain.ItemsInteractor

class ItemsPresenter(private val itemsView: ItemsView,
                     private val itemsInteractor: ItemsInteractor
) {
    fun getData(){
        val listItems = itemsInteractor.getData()
        itemsView.dataReceived(listItems)
    }

    fun elementSelected(imageTitle: Int, title: String, description: String, time: String){
        itemsView.goToDetails(imageTitle, title, description, time)
    }
}