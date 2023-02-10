package com.example.android_homework.di

import com.example.android_homework.domain.auth.AuthInteractor
import com.example.android_homework.domain.auth.AuthRepository
import com.example.android_homework.domain.items.ItemsInteractor
import com.example.android_homework.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides


@Module
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }
    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }

}
