package com.example.data.network.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ImageApi {

    @GET("/{type}/{id}?json=true")
    suspend fun loadNext(@Path("type") type: String, @Path("id") long: Long) : Unit
}