package com.example.sirius.fragment.page.di

import com.example.sirius.app.di.AppComponentHolder
import com.example.sirius.core.di.ComponentHolder

object PageFragmentComponentHolder : ComponentHolder<PageFragmentComponent>() {

    override fun buildComponent(): PageFragmentComponent = DaggerPageFragmentComponent.builder()
        .appComponent(AppComponentHolder.getComponent())
        .build()
}