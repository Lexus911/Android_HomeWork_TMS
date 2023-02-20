package com.example.android_homework.data.service

import com.example.android_homework.data.model.ItemsResponse
import io.reactivex.Single
import retrofit2.http.GET


interface ApiService {

    @GET("/users")
     fun getData(): Single<List<ItemsResponse>>
}