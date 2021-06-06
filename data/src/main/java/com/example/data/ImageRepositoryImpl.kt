package com.example.data

import com.example.data.mapper.ImageNetToDomainMapper
import com.example.data.network.api.ImageApi
import com.example.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(

    private val imageApi: ImageApi,
    private val mapper: ImageNetToDomainMapper

) : ImageRepository {

    override suspend fun loadNext() = imageApi.loadNext().run(mapper)

}