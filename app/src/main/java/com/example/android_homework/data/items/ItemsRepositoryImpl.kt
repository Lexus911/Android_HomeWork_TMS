package com.example.android_homework.data.items


import com.example.android_homework.data.database.ItemsEntity
import com.example.android_homework.data.database.dao.ItemsDAO
import com.example.android_homework.data.service.ApiService
import com.example.android_homework.domain.items.ItemsRepository
import com.example.android_homework.presentation.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDAO: ItemsDAO

): ItemsRepository {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            if (!itemsDAO.doesItemsEntityExist()) {
                val response = apiService.getData()
                response.body()?.let { it ->
                    it.map {
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
                        )
                        itemsDAO.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.getItemsEntities()
            itemsEntity.map{
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
                    it.lng
                )
            }
        }
    }
}

