package com.example.sirius.app.di

import com.example.sirius.core.di.ComponentHolder

object AppComponentHolder : ComponentHolder<AppComponent>() {
    override fun buildComponent(): AppComponent = DaggerAppComponent.builder().build()
}