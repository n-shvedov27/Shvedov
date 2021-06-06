package com.example.domain.use_case.get_image_by_index

import com.example.domain.entity.ImageDomain

interface GetImageByIndex {

    suspend fun execute(index: Int): ImageDomain

}