package com.example.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {

//    @GET("/api/v1/index/constituents")
//    suspend fun loadNextOmage(
//        @Query("symbol") symbol: String,
//        @Query("token") token: String
//    ): ConstituentsResponse

    @GET("/awd")
    suspend fun loadNext() : Unit
}