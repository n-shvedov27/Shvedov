package com.example.sirius.fragment.page.di.module

import com.example.data.ImageRepositoryImpl
import com.example.domain.ImageRepository
import dagger.Binds
import dagger.Module

@Module
abstract class PageFragmentDataModule {

    @Binds
    abstract fun bindImageRepository(repository: ImageRepositoryImpl): ImageRepository

}