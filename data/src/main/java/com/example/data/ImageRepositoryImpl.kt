package com.example.data

import com.example.data.db.entity.ImageDb
import com.example.data.db.storage.ImageStorage
import com.example.data.mapper.ImageDbToDomainMapper
import com.example.data.mapper.ImageNetToDbMapper
import com.example.data.mapper.ImageNetToDomainMapper
import com.example.data.network.api.ImageApi
import com.example.domain.entity.ImageDomain
import com.example.domain.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(

    private val imageApi: ImageApi,
    private val imageStorage: ImageStorage,
    private val imageNetToDbMapper: ImageNetToDbMapper,
    private val imageNetToDomainMapper: ImageNetToDomainMapper,
    private val imageDbToDomainMapper: ImageDbToDomainMapper

) : ImageRepository {

    private suspend fun loadNext() = imageApi.loadNext()

    private suspend fun saveByIndex(image: ImageDb, index: Int) = withContext(Dispatchers.IO) {
        imageStorage.save(image.apply { this.index = index })
    }

    private suspend fun loadAndCacheByIndex(index: Int) = loadNext().apply {
        saveByIndex(this.run(imageNetToDbMapper), index)
    }

    override suspend fun getByIndex(index: Int): ImageDomain {

        return when (val cachedModel = imageStorage.getByIndex(index)) {

            null -> loadAndCacheByIndex(index).run(imageNetToDomainMapper)

            else -> cachedModel.run(imageDbToDomainMapper)
        }
    }
}