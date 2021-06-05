package com.example.data

import com.example.data.network.api.ImageApi
import com.example.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(

    private val imageApi: ImageApi

) : ImageRepository {

    override fun loadNext() {
        TODO("Not yet implemented")
    }
}