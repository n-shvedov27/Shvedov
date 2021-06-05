package com.example.sirius.app.di

import com.example.data.di.ApiModule
import com.example.data.network.api.ImageApi
import com.example.sirius.core.di.DIComponent
import dagger.Component

@Component(
    modules = [
        ApiModule::class
    ]
)
interface AppComponent : DIComponent {

    var imageApi: ImageApi

}