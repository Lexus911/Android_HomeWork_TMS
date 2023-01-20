package com.example.android_homework.data.items


import com.example.android_homework.data.service.ApiService
import com.example.android_homework.domain.items.ItemsRepository
import com.example.android_homework.presentation.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ItemsRepository {
    override suspend fun getData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getData()
            response.body()?.let{ it ->
                it.map {
                    ItemsModel(
                        it.id,
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
                }
            } ?: kotlin.run{
                emptyList()
            }
        }
    }
}
