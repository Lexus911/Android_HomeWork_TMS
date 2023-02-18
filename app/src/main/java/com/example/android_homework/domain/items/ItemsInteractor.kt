package com.example.android_homework.domain.items

import com.example.android_homework.presentation.model.FavoritesModel
import com.example.android_homework.presentation.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

     fun getData(): Completable {
        return itemsRepository.getData()
    }

     fun showData(): Observable<List<ItemsModel>> {
        return itemsRepository.showData()
    }

    suspend fun deleteItemById(id: Int){
        itemsRepository.deleteItemById(id)
    }

    suspend fun deleteFavItemById(id:Int){
        itemsRepository.deleteFavById(id)
    }

//    suspend fun findItem(searchId: Int): ItemsModel{
//        return itemsRepository.findItemById(searchId)
//    }

    suspend fun onFavClicked(id: Int){
        val foundItem = itemsRepository.findItemById(id)
        itemsRepository.favClicked(foundItem)
    }

    suspend fun getFavorites(): Flow<List<FavoritesModel>>{
        return itemsRepository.getFavorites()
    }

    suspend fun updateFavorite(favorite: Boolean, id: Int){
        return itemsRepository.updateFavorite(favorite, id)
    }


}