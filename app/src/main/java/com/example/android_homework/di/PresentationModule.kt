package com.example.android_homework.di

import com.example.android_homework.domain.auth.AuthInteractor
import com.example.android_homework.domain.items.ItemsInteractor
import com.example.android_homework.presentation.view.MainPresenter
import com.example.android_homework.presentation.view.auth.LoginPresenter
import com.example.android_homework.presentation.view.auth.RegistrationPresenter
import com.example.android_homework.presentation.view.home.DetailsPresenter
import com.example.android_homework.presentation.view.home.ItemsPresenter
import com.example.android_homework.presentation.view.home.MainScreenPresenter
import com.example.android_homework.presentation.view.home.NestedPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideItemsPresenter(itemsInteractor: ItemsInteractor): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }

    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter{
        return MainPresenter(authInteractor)
    }

    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter{
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideRegistrationPresenter(): RegistrationPresenter{
        return RegistrationPresenter()
    }

    @Provides
    fun provideDetailsPresenter(authInteractor: AuthInteractor): DetailsPresenter {
        return DetailsPresenter(authInteractor)
    }

    @Provides
    fun provideNestedPresenter(): NestedPresenter {
        return NestedPresenter()
    }

    @Provides
    fun provideMainScreenPresenter(authInteractor: AuthInteractor): MainScreenPresenter {
        return MainScreenPresenter(authInteractor)
    }
}