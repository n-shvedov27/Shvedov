package com.example.sirius.core.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sirius.core.di.UIComponent

abstract class BaseFragment : Fragment() {

    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract fun diComponent(): UIComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModelFactory = createViewModelFactory()

    }

    private fun createViewModelFactory(): ViewModelProvider.Factory = with(diComponent()) {
        return@with viewModelFactory
    }

    inline fun <reified T : ViewModel> injectViewModel() = lazy {

        ViewModelProvider(this, viewModelFactory)[T::class.java]
    }
}