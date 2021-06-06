package com.example.data.mapper

import com.example.data.db.entity.ImageDb
import com.example.domain.entity.ImageDomain
import javax.inject.Inject

class ImageDomainToDbMapper @Inject constructor(

) : (ImageDomain) -> ImageDb {

    override fun invoke(model: ImageDomain) = ImageDb().apply {
        id = model.id
        description = model.description
        url = model.url
    }
}