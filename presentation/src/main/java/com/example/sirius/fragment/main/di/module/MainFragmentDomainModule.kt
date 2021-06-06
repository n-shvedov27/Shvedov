package com.example.sirius.fragment.main.di.module

import com.example.domain.use_case.get_image_by_index.GetImageByIndex
import com.example.domain.use_case.get_image_by_index.GetImageByIndexImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MainFragmentDomainModule {

    @Binds
    abstract fun bindGetImageByIndex(impl: GetImageByIndexImpl): GetImageByIndex
}