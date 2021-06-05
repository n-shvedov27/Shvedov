package com.example.sirius.fragment.page.di

import com.example.sirius.app.di.AppComponent
import com.example.sirius.core.di.UIComponent
import com.example.sirius.fragment.page.di.module.PageFragmentPresentationModule
import dagger.Component

@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        PageFragmentPresentationModule::class
    ]
)
interface PageFragmentComponent : UIComponent