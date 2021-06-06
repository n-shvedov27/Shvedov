package com.example.domain

interface ImageRepository {

    suspend fun loadNext() : ImageDomain

}