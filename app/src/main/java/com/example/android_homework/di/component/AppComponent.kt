package com.example.android_homework.di.component

import com.example.android_homework.di.AppModule
import com.example.android_homework.di.DataBaseModule
import com.example.android_homework.di.DataModule
import com.example.android_homework.di.DomainModule
import com.example.android_homework.presentation.view.MainActivity
import com.example.android_homework.presentation.view.auth.LoginFragment
import com.example.android_homework.presentation.view.auth.RegistrationFragment
import com.example.android_homework.presentation.view.home.MainScreenFragment
import com.example.android_homework.presentation.view.home.NestedFragment
import com.example.android_homework.presentation.view.home.items.DetailsFragment
import com.example.android_homework.presentation.view.home.items.FavoritesFragment
import com.example.android_homework.presentation.view.home.items.ItemsFragment
import dagger.Component


@Component(
    modules = [
    AppModule::class,
    DataModule::class,
    DomainModule::class,
    DataBaseModule::class,

    ]
)

@ScreenScope
interface AppComponent {
    fun inject(fragment: LoginFragment)
    fun inject(fragment: DetailsFragment)
    fun inject(fragment: ItemsFragment)
    fun inject(fragment: FavoritesFragment)
    fun inject(fragment: RegistrationFragment)
    fun inject(fragment: MainScreenFragment)
    fun inject(fragment: NestedFragment)
    fun inject(activity: MainActivity)
}