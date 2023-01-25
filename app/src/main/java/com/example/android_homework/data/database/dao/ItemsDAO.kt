package com.example.android_homework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_homework.data.database.ItemsEntity

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * From ItemsEntity")
    fun getItemsEntities(): List<ItemsEntity>

    @Query("SELECT(SELECT COUNT(*) From ItemsEntity) != 0")
    fun doesItemsEntityExist(): Boolean

}