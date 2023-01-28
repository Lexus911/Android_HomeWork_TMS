package com.example.android_homework.presentation.view.home.items

import android.util.Log
import com.example.android_homework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {
    private lateinit var favoritesView: FavoritesView
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("Favorites exceptionHandlerCalled", exception.toString())
    }

    fun setView(context: FavoritesView){
        favoritesView = context
    }


    fun getFavorites(){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    val favoritesItems = itemsInteractor.getFavorites()
                    favoritesView.favReceived(favoritesItems)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","getFavorites FAILED")
            }
        }

    }

    fun deleteFavItem(id: Int){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.deleteFavItemById(id)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","onFavClicked FAILED")
            }
        }

    }
}