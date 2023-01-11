package com.example.android_homework.presentation.view


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_homework.domain.items.ItemsInteractor
import com.example.android_homework.presentation.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
): ViewModel() {

        private val _items = MutableLiveData<List<ItemsModel>>()
        val items: LiveData<List<ItemsModel>> = _items

        private val _bundle = MutableLiveData<NavigateWithBundle?>()
        val bundle: LiveData<NavigateWithBundle?> = _bundle

        fun getData() {
            viewModelScope.launch {
                try {
                    val listItems = itemsInteractor.getData()
                    _items.value = listItems
                }
                catch (e: Exception){
                    Log.w("exception","getData FAILED")
                }
            }

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