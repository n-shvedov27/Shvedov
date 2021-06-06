package com.example.sirius.fragment.main.di.module

import com.example.data.ImageRepositoryImpl
import com.example.domain.ImageRepository
import dagger.Binds
import dagger.Module

@Module
abstract class MainFragmentDataModule {

    @Binds
    abstract fun bindImageRepository(repository: ImageRepositoryImpl): ImageRepository

}