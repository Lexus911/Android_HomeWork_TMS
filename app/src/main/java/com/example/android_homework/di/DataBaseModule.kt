package com.example.android_homework.di

import android.content.Context
import com.example.android_homework.data.database.dao.ItemsDAO
import com.example.android_homework.data.database.dao.ItemsDataBase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    fun itemsDataBase(context: Context): ItemsDataBase {
        return ItemsDataBase.getItemsDataBaseInstance(context)
    }

    @Provides
    fun provideItemsDao(itemsDataBase: ItemsDataBase): ItemsDAO {
        return itemsDataBase.getItemsDAO()
    }
}