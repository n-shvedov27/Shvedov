package com.example.sirius.core.di

import com.example.sirius.core.vm.BaseViewModelFactory

interface UIComponent : DIComponent {

    val viewModelFactory: BaseViewModelFactory

}