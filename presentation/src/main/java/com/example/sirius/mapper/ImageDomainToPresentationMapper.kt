package com.example.sirius.mapper

import com.example.domain.entity.ImageDomain
import com.example.sirius.entity.ImageItem
import javax.inject.Inject

class ImageDomainToPresentationMapper @Inject constructor(

) : (ImageDomain) -> ImageItem {

    override fun invoke(model: ImageDomain) = ImageItem(
        id = model.id,
        url = model.url,
        description = model.description
    )
}