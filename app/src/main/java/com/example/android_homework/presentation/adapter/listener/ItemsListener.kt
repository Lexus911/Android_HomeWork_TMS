package com.example.android_homework.presentation.adapter.listener

interface ItemsListener {
    fun onElementSelected(name: String, username: String, email: String)

    fun onFavClicked(id: Int)

    fun onDeleteClicked(id: Int)

    fun updateFavorite(favorite: Boolean, id: Int)
}