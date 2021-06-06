package com.example.data.db.storage

import com.example.data.db.entity.ImageDb

interface ImageStorage {

    fun save(model: ImageDb)

    fun getByIndex(index: Int): ImageDb?

}