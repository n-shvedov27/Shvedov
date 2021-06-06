package com.example.data.mapper

import com.example.data.network.entity.ImageNet
import com.example.domain.ImageDomain
import javax.inject.Inject

class ImageNetToDomainMapper @Inject constructor(

) : (ImageNet) -> ImageDomain {

    override fun invoke(model: ImageNet) = ImageDomain(
        id = model.id,
        description = model.description,
        url = model.url
    )
}