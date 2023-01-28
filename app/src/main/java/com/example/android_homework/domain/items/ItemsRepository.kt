package com.example.android_homework.domain.items

import com.example.android_homework.presentation.model.FavoritesModel
import com.example.android_homework.presentation.model.ItemsModel

interface ItemsRepository {
    suspend fun getData()

    suspend fun showData(): List<ItemsModel>

    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun deleteItemById(id: Int)

    suspend fun deleteFavById(id: Int)

    suspend fun findItemById(Id: Int): ItemsModel

    suspend fun getFavorites(): List<FavoritesModel>

}