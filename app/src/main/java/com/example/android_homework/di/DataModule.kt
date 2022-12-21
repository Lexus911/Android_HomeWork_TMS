package com.example.android_homework.di

import android.content.Context
import com.example.android_homework.data.auth.AuthRepositoryImpl
import com.example.android_homework.data.items.ItemsRepositoryImpl
import com.example.android_homework.data.sharedpref.SharedPreferencesHelper
import com.example.android_homework.domain.auth.AuthRepository
import com.example.android_homework.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindItemsRepository(itemsRepositoryImpl: ItemsRepositoryImpl): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    companion object{
        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferencesHelper {
            return SharedPreferencesHelper(context.getSharedPreferences(SP_KEY,
                Context.MODE_PRIVATE
            ))
        }
    }
}
