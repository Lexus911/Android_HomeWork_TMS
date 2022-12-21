package com.example.android_homework.domain.items

import com.example.android_homework.presentation.model.ItemsModel

interface ItemsRepository {
    fun getData():List<ItemsModel>
}