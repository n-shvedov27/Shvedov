package com.example.sirius.core.di

import androidx.annotation.CallSuper
import androidx.annotation.VisibleForTesting

abstract class ComponentHolder<T : DIComponent> {

    protected open val mode =
        ComponentHolderMode.CLEARABLE_SINGLETON

    private var component: T? = null

    protected abstract fun buildComponent(): T

    open fun getComponent(): T = when (mode) {

        ComponentHolderMode.CLEARABLE_SINGLETON,
        ComponentHolderMode.GLOBAL_SINGLETON -> {

            if (component == null) {
                component = createComponent()
            }

            component!!
        }
        ComponentHolderMode.ALWAYS_CREATE_NEW -> createComponent()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun setComponent(component: T) {
        this.component = component
    }

    protected open fun createComponent(): T = buildComponent()

    /**
     * open — т.к. может возникнуть ситуация, когда при очистке компонента нужно почистить связанные с ним
     */
    @CallSuper
    open fun clearComponent() = when (mode) {

        ComponentHolderMode.GLOBAL_SINGLETON -> {}
        else -> component = null
    }

    enum class ComponentHolderMode {

        /**
         * Синглтон, который можно (нужно) чистить вызовом
         * @see clearComponent
         */
        CLEARABLE_SINGLETON,

        /**
         * Всегда новый инстанс компонента
         */
        ALWAYS_CREATE_NEW,

        /**
         * Глобальный синглтон, который инициализируется один раз и навсегда
         */
        GLOBAL_SINGLETON
    }
}