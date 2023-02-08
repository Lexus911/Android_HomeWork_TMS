package com.example.android_homework.data.items


import com.example.android_homework.data.database.FavoritesEntity
import com.example.android_homework.data.database.ItemsEntity
import com.example.android_homework.data.database.dao.ItemsDAO
import com.example.android_homework.data.service.ApiService
import com.example.android_homework.domain.items.ItemsRepository
import com.example.android_homework.presentation.model.FavoritesModel
import com.example.android_homework.presentation.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDAO: ItemsDAO

): ItemsRepository {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            itemsDAO.doesItemsEntityExist().collect {
                if (!it) {
                    val response = apiService.getData()
                    response.body()?.let { response ->
                        response.map {it ->
                            val itemsEntity = ItemsEntity(
                                Random().nextInt(999 - 1),
                                it.name,
                                it.username,
                                it.email,
                                it.phone,
                                it.website,
                                it.address.street,
                                it.address.suite,
                                it.address.city,
                                it.address.zipcode,
                                it.company.name,
                                it.company.catchPhrase,
                                it.company.bs,
                                it.address.geo.lat,
                                it.address.geo.lng,
                                it.favorite
                            )
                            itemsDAO.insertItemsEntity(itemsEntity)
                        }
                    }
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<ItemsModel>> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.getItemsEntities()
            itemsEntity.map { itemsList ->
                itemsList.map {
                    ItemsModel(
                        it.id,
                        it.name,
                        it.username,
                        it.email,
                        it.phone,
                        it.website,
                        it.street,
                        it.suite,
                        it.city,
                        it.zipcode,
                        it.nameCompany,
                        it.catchPhrase,
                        it.bs,
                        it.lat,
                        it.lng,
                        it.favorite
                    )
                }
            }
        }
    }

    override suspend fun favClicked(itemsModel: ItemsModel) {
        return withContext(Dispatchers.IO) {
            itemsDAO.insertFavoritesEntity(
                FavoritesEntity(
                    itemsModel.id,
                    itemsModel.name,
                    itemsModel.username,
                    itemsModel.email,
                    itemsModel.phone,
                    itemsModel.website,
                    itemsModel.street,
                    itemsModel.suite,
                    itemsModel.city,
                    itemsModel.zipcode,
                    itemsModel.nameCompany,
                    itemsModel.catchPhrase,
                    itemsModel.bs,
                    itemsModel.lat,
                    itemsModel.lng,
                    itemsModel.favorite
                )
            )
        }
    }

    override suspend fun deleteItemById(id: Int) {
        withContext(Dispatchers.IO) {
            itemsDAO.deleteItemEntityById(id)
        }
    }

    override suspend fun deleteFavById(id: Int) {
        withContext(Dispatchers.IO) {
            itemsDAO.deleteFavEntityById(id)
        }
    }

    override suspend fun findItemById(id: Int): ItemsModel {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.findItemEntityById(id)
            ItemsModel(
                itemsEntity.id,
                itemsEntity.name,
                itemsEntity.username,
                itemsEntity.email,
                itemsEntity.phone,
                itemsEntity.website,
                itemsEntity.street,
                itemsEntity.suite,
                itemsEntity.city,
                itemsEntity.zipcode,
                itemsEntity.nameCompany,
                itemsEntity.catchPhrase,
                itemsEntity.bs,
                itemsEntity.lat,
                itemsEntity.lng,
                itemsEntity.favorite
            )
        }
    }

    override suspend fun getFavorites(): Flow<List<FavoritesModel>> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDAO.getFavoritesEntities()
            favoritesEntity.map { favoritesList ->
                favoritesList.map {
                    FavoritesModel(
                        it.id,
                        it.name,
                        it.username,
                        it.email,
                        it.phone,
                        it.website,
                        it.street,
                        it.suite,
                        it.city,
                        it.zipcode,
                        it.nameCompany,
                        it.catchPhrase,
                        it.bs,
                        it.lat,
                        it.lng,
                        it.favorite,
                    )
                }
            }
        }
    }

    override suspend fun updateFavorite(favorite: Boolean, id: Int) {
        return withContext(Dispatchers.IO) {
            itemsDAO.updateFavorite(favorite, id)
        }
    }
}

