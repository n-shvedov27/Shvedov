package com.example.sirius.fragment.image.di

import com.example.sirius.app.di.AppComponent
import com.example.sirius.core.di.UIComponent
import com.example.sirius.fragment.image.di.module.ImageFragmentPresentationModule
import com.example.sirius.fragment.page.di.module.PageFragmentPresentationModule
import dagger.Component

@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        ImageFragmentPresentationModule::class
    ]
)
interface ImageFragmentComponent : UIComponent