package com.example.android_homework.di

import com.example.android_homework.domain.auth.AuthInteractor
import com.example.android_homework.domain.items.ItemsInteractor
import com.example.android_homework.presentation.view.MainPresenter
import com.example.android_homework.presentation.view.auth.LoginPresenter
import com.example.android_homework.presentation.view.auth.RegistrationPresenter
import com.example.android_homework.presentation.view.home.MainScreenPresenter
import com.example.android_homework.presentation.view.home.NestedPresenter
import com.example.android_homework.presentation.view.home.items.DetailsPresenter
import com.example.android_homework.presentation.view.home.items.FavoritesPresenter
import com.example.android_homework.presentation.view.home.items.ItemsPresenter
import dagger.Module
import dagger.Provides

@Module
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
    fun provideRegistrationPresenter(authInteractor: AuthInteractor): RegistrationPresenter{
        return RegistrationPresenter(authInteractor)
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

    @Provides
    fun provideFavoritesPresenter(itemsInteractor: ItemsInteractor): FavoritesPresenter {
        return FavoritesPresenter(itemsInteractor)
    }


}