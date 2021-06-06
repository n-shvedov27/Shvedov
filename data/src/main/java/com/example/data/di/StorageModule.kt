package com.example.data.di

import com.example.data.db.storage.ImageStorage
import com.example.data.db.storage.ImageStorageImpl
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {

    @Binds
    abstract fun bindImageStorage(imageStorageImpl: ImageStorageImpl) : ImageStorage

}