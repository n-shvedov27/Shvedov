package com.example.sirius.fragment.page.di.module

import androidx.lifecycle.ViewModel
import com.example.sirius.core.di.ViewModelKey
import com.example.sirius.fragment.page.PageFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        PageFragmentDataModule::class
    ]
)
abstract class PageFragmentPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(PageFragmentViewModel::class)
    abstract fun bindViewModel(vm: PageFragmentViewModel): ViewModel
}