package com.example.android_homework.di

import com.example.android_homework.domain.ItemsInteractor
import com.example.android_homework.domain.ItemsRepository
import com.example.android_homework.presentation.ItemsPresenter
import com.example.android_homework.presentation.ItemsView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }
    @Provides
    fun provideItemsPresenter(itemsView: ItemsView,itemsInteractor: ItemsInteractor ): ItemsPresenter {
        return ItemsPresenter(itemsView, itemsInteractor)
    }
}
