package com.example.sirius.core.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class BaseViewModelFactory @Inject constructor(

    private val creators: MutableMap<Class<out ViewModel>, Provider<ViewModel>>

) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = creators[modelClass]?.get() as? T
        ?: throw IllegalArgumentException("The requested ViewModel isn't bound")
}