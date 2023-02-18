package com.example.android_homework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_homework.data.database.FavoritesEntity
import com.example.android_homework.data.database.ItemsEntity
import com.example.android_homework.data.database.UsersEntity
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * From ItemsEntity")
    fun getItemsEntities(): Observable<List<ItemsEntity>>

    @Query("SELECT(SELECT COUNT(*) From ItemsEntity) != 0")
    fun doesItemsEntityExist(): Observable<Boolean>

    @Query("DELETE FROM ItemsEntity WHERE id =:id")
    fun deleteItemEntityById(id: Int)

    @Query("SELECT * From ItemsEntity WHERE id = :searchId")
    fun findItemEntityById(searchId: Int): ItemsEntity

    @Query("UPDATE ItemsEntity SET favorite =:favorite WHERE id =:id")
    fun updateFavorite(favorite: Boolean, id: Int)



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * From FavoritesEntity")
    fun getFavoritesEntities(): Flow<List<FavoritesEntity>>

    @Query("DELETE FROM FavoritesEntity WHERE id =:id")
    fun deleteFavEntityById(id: Int)



    @Insert
    fun insertUsersEntity(usersEntity: UsersEntity)

    @Query("SELECT * From UsersEntity")
    fun getUsersEntities(): List<UsersEntity>
}