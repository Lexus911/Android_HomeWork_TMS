package com.example.android_homework.presentation.view.home

import android.util.Log
import com.example.android_homework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("Items exceptionHandlerCalled", exception.toString())
    }

    fun setView(context: ItemsView){
        itemsView = context
    }

    fun getData(){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    val listItems = itemsInteractor.getData()
                    itemsView.dataReceived(listItems)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","getData FAILED")
            }
        }

    }

    fun elementSelected(name: String, username: String, email: String){
        itemsView.goToDetails(name, username, email)
    }
}