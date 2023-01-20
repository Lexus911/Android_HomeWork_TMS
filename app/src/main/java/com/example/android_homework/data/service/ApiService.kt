package com.example.android_homework.data.service

import com.example.android_homework.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("/users")
    suspend fun getData(): Response<List<ItemsResponse>>
}