package com.example.data.network.api

import com.example.data.network.entity.ImageNet
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageApi {

    @GET("/random?json=true")
    suspend fun loadNext() : ImageNet
}