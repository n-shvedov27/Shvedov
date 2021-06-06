package com.example.data.mapper

import com.example.data.db.entity.ImageDb
import com.example.domain.entity.ImageDomain
import javax.inject.Inject

class ImageDbToDomainMapper @Inject constructor(

) : (ImageDb) -> ImageDomain {

    override fun invoke(model: ImageDb) = ImageDomain(
        id = model.id!!,
        description = model.description!!,
        url = model.url!!
    )
}