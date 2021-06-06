package com.example.domain.use_case.get_image_by_index

import com.example.domain.ImageRepository
import javax.inject.Inject

class GetImageByIndexImpl @Inject constructor(

    private val repository: ImageRepository

) : GetImageByIndex {

    override suspend fun execute(index: Int) = repository.getByIndex(index)

}