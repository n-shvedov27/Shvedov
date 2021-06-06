package com.example.sirius.fragment.main.di

import com.example.sirius.app.di.AppComponent
import com.example.sirius.core.di.UIComponent
import com.example.sirius.fragment.main.di.module.MainFragmentPresentationModule
import dagger.Component

@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        MainFragmentPresentationModule::class
    ]
)
interface MainFragmentComponent : UIComponent