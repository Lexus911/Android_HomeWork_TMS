package com.example.android_homework.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_homework.domain.ItemsInteractor


class ItemsViewModelFactory(
    private val itemsInteractor: ItemsInteractor
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}