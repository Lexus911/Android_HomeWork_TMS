package com.example.android_homework.presentation.view.home.items

import com.example.android_homework.presentation.model.FavoritesModel

interface FavoritesView {

    fun favReceived (list: List<FavoritesModel>)
}