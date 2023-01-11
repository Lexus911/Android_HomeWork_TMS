package com.example.android_homework.domain.items

import com.example.android_homework.presentation.model.ItemsModel

interface ItemsRepository {
    suspend fun getData():List<ItemsModel>
}