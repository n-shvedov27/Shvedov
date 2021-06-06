package com.example.data.network.api

import com.example.data.network.entity.ImageNet
import retrofit2.http.GET

interface ImageApi {

    @GET("/random?json=true")
    suspend fun loadNext() : ImageNet
}