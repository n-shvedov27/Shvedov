package com.example.data.di

import com.example.data.network.api.ImageApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provdieGsonFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    fun httpClient() : OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun provideHost(): String = "https://developerslife.ru/"

    @Provides
    fun provideRetrofit(

        gsonConverterFactory: GsonConverterFactory,
        host: String,
        httpClient: OkHttpClient

    ): Retrofit = Retrofit.Builder()
        .baseUrl(host)
        .addConverterFactory(gsonConverterFactory)
        .client(httpClient)
        .build()

    @Provides
    fun provideApi(

        retrofit: Retrofit

    ): ImageApi = retrofit.create(ImageApi::class.java)
}