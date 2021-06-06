package com.example.sirius.fragment.main.di.module

import androidx.lifecycle.ViewModel
import com.example.sirius.core.di.ViewModelKey
import com.example.sirius.fragment.main.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        MainFragmentDataModule::class,
        MainFragmentDomainModule::class
    ]
)
abstract class MainFragmentPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    abstract fun bindViewModel(vm: MainFragmentViewModel): ViewModel
}