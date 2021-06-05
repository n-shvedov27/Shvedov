package com.example.sirius.fragment.image.di.module

import com.example.data.ImageRepositoryImpl
import com.example.domain.ImageRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ImageFragmentDataModule {

    @Binds
    abstract fun bindImageRepository(repository: ImageRepositoryImpl): ImageRepository

}