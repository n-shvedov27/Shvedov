package com.example.sirius.fragment.image.di

import com.example.sirius.app.di.AppComponentHolder
import com.example.sirius.core.di.ComponentHolder

object ImageFragmentComponentHolder : ComponentHolder<ImageFragmentComponent>() {

    override fun buildComponent(): ImageFragmentComponent = DaggerImageFragmentComponent.builder()
        .appComponent(AppComponentHolder.getComponent())
        .build()
}