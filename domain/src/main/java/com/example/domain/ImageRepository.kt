package com.example.domain

import com.example.domain.entity.ImageDomain

interface ImageRepository {

    suspend fun getByIndex(index: Int) : ImageDomain

}