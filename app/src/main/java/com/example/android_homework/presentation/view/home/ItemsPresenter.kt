package com.example.android_homework.presentation.view.home

import com.example.android_homework.domain.items.ItemsInteractor
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView){
        itemsView = context
    }

    fun getData(){
        val listItems = itemsInteractor.getData()
        itemsView.dataReceived(listItems)
    }

    fun elementSelected(imageTitle: Int, title: String, description: String, time: String){
        itemsView.goToDetails(imageTitle, title, description, time)
    }
}