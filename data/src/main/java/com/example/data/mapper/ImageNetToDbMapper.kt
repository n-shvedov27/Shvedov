package com.example.data.mapper

import com.example.data.db.entity.ImageDb
import com.example.data.network.entity.ImageNet
import javax.inject.Inject

class ImageNetToDbMapper @Inject constructor(

) : (ImageNet) -> ImageDb {

    override fun invoke(model: ImageNet) = ImageDb().apply {
        id = model.id
        description = model.description
        url = model.url
    }
}