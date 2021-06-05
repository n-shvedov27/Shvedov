package com.example.sirius.fragment.image.di.module

import androidx.lifecycle.ViewModel
import com.example.sirius.core.di.ViewModelKey
import com.example.sirius.fragment.image.ImageFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ImageFragmentDataModule::class
    ]
)
abstract class ImageFragmentPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(ImageFragmentViewModel::class)
    abstract fun bindViewModel(vm: ImageFragmentViewModel): ViewModel
}