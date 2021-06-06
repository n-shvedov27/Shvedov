package com.example.sirius.fragment.main.di

import com.example.sirius.app.di.AppComponentHolder
import com.example.sirius.core.di.ComponentHolder

object MainFragmentComponentHolder : ComponentHolder<MainFragmentComponent>() {

    override fun buildComponent(): MainFragmentComponent = DaggerMainFragmentComponent.builder()
        .appComponent(AppComponentHolder.getComponent())
        .build()
}