package com.example.android_homework.domain.items

import com.example.android_homework.presentation.model.FavoritesModel
import com.example.android_homework.presentation.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

    fun getData(): Completable

    fun showData(): Observable<List<ItemsModel>>

    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun deleteItemById(id: Int)

    suspend fun deleteFavById(id: Int)

    suspend fun findItemById(id: Int): ItemsModel

    suspend fun getFavorites(): Flow<List<FavoritesModel>>

    suspend fun updateFavorite(favorite: Boolean, id: Int)
}