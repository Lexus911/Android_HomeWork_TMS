package com.example.android_homework.presentation.view.home.items

import android.util.Log
import com.example.android_homework.domain.items.ItemsInteractor
import com.example.android_homework.presentation.model.ItemsModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("Items exceptionHandlerCalled", exception.toString())
    }

    private val compositeDisposable = CompositeDisposable()

    fun setView(context: ItemsView){
        itemsView = context
    }

     fun getData(){
         val getData = itemsInteractor.getData().subscribe({

         },{

         })
         compositeDisposable.add(getData)

         val showData = itemsInteractor.showData().subscribe({
             itemsView.dataReceived(it)
         },{

         })
         compositeDisposable.add(showData)
    }


    fun elementSelected(name: String, username: String, email: String){
        itemsView.goToDetails(name, username, email)
    }

    fun onFavClicked(id: Int){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.onFavClicked(id)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","onFavClicked FAILED")
            }
        }
    }

    fun deleteItem(id: Int){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.deleteItemById(id)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","deleteItem FAILED")
            }
        }
    }

   fun updateFavorite(favorite: Boolean, id: Int){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.updateFavorite(favorite, id)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","updateFav FAILED")
            }
        }
    }

}