package com.example.android_homework.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_homework.domain.ItemsInteractor
import com.example.android_homework.presentation.model.ItemsModel


class ItemsViewModel(
    private val itemsInteractor: ItemsInteractor
): ViewModel() {

        private val _items = MutableLiveData<List<ItemsModel>>()
        val items: LiveData<List<ItemsModel>> = _items

        private val _bundle = MutableLiveData<NavigateWithBundle?>()
        val bundle: LiveData<NavigateWithBundle?> = _bundle

        fun getData() {
            val listItems = itemsInteractor.getData()
            _items.value = listItems
        }
        fun elementClicked(imageTitle: Int, title: String, description: String, time: String){
            _bundle.value = NavigateWithBundle(imageTitle, title, description, time)
        }

        fun userNavigated(){
             _bundle.value = null
        }
}

data class NavigateWithBundle(
    val imageTitle: Int,
    val title: String,
    val description: String,
    val time: String,
    )