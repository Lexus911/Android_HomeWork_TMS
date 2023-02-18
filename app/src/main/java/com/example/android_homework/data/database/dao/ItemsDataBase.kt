package com.example.android_homework.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_homework.data.database.FavoritesEntity
import com.example.android_homework.data.database.ItemsEntity
import com.example.android_homework.data.database.UsersEntity

@Database(entities = [ItemsEntity::class, FavoritesEntity::class, UsersEntity::class], version = 1, exportSchema = false)
abstract class ItemsDataBase : RoomDatabase() {
    abstract fun getItemsDAO(): ItemsDAO

    companion object{
        private const val DATABASE_NAME = "tms_db"
        private var DATABASE_INSTANCE: ItemsDataBase? = null

        fun getItemsDataBaseInstance(context: Context): ItemsDataBase{
            return DATABASE_INSTANCE?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDataBase::class.java,
                    DATABASE_NAME
                )
                .allowMainThreadQueries()
                .build()
                .also{ DATABASE_INSTANCE = it }
        }
    }
}