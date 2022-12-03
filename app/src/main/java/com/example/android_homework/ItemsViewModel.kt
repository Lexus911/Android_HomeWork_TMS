package com.example.android_homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_homework.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val KEY_IMAGE_TITLE = "imageTitle"
const val KEY_TITLE = "title"
const val KEY_DESCRIPTION = "description"
const val KEY_TIME = "time"
const val KEY_BACKSTACK_NAME = "Details"

class ItemsViewModel: ViewModel() {

        private val _items = MutableLiveData<List<ItemsModel>>()
        val items: LiveData<List<ItemsModel>> = _items

        private val _bundle = MutableLiveData<NavigateWithBundle>()
        val bundle: LiveData<NavigateWithBundle> = _bundle

        fun getData() {
            val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
            val listItems = listOf<ItemsModel>(
                ItemsModel(R.drawable.we_are_the_champions, "We are the champions", "Album: New of the World - 1977", time, R.drawable.white_star),
                ItemsModel(R.drawable.we_will_rock_you, "We will rock you", "Album: New of the World - 1977", time, R.drawable.white_star),
                ItemsModel(R.drawable.radio_ga_ga, "Radio ga ga", "Album: The Works - 1984", time, R.drawable.white_star),
                ItemsModel(R.drawable.i_want_it_all, "I want it all", "Album: The Miracle - 1989", time,R.drawable.white_star),
                ItemsModel(R.drawable.bohemian_rhapsody, "We are the champions", "Album: A night at the Opera - 1975", time, R.drawable.white_star),
                ItemsModel(R.drawable.the_show_must_go_on, "We are the champions", "Album: Innuendo - 1991", time, R.drawable.white_star)
            )
            _items.value = listItems
        }
        fun elementClicked(imageTitle: Int, title: String, description: String, time: String){
            _bundle.value = NavigateWithBundle(imageTitle, title, description, time)
        }
}

data class NavigateWithBundle(
    val imageTitle: Int,
    val title: String,
    val description: String,
    val time: String,
    )