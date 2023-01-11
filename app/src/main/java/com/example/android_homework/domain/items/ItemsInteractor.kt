package com.example.android_homework.domain.items

import com.example.android_homework.presentation.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    suspend fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}