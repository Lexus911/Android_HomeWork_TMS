package com.example.android_homework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_homework.data.database.FavoritesEntity
import com.example.android_homework.data.database.ItemsEntity

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * From ItemsEntity")
    fun getItemsEntities(): List<ItemsEntity>

    @Query("SELECT(SELECT COUNT(*) From ItemsEntity) != 0")
    fun doesItemsEntityExist(): Boolean

    @Query("DELETE FROM ItemsEntity WHERE id =:id")
    fun deleteItemEntityById(id: Int)

    @Query("SELECT * From ItemsEntity WHERE id = :searchId")
    fun findItemEntityById(searchId: Int): ItemsEntity


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * From FavoritesEntity")
    fun getFavoritesEntities(): List<FavoritesEntity>

    @Query("DELETE FROM FavoritesEntity WHERE id =:id")
    fun deleteFavEntityById(id: Int)

}