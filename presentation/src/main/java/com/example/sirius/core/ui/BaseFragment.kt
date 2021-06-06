package com.example.sirius.core.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sirius.core.di.UIComponent
import com.example.sirius.core.vm.BaseViewModel

abstract class BaseFragment : Fragment() {

    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: ViewDataBinding? = null

    @get:LayoutRes
    protected abstract val layoutId: Int
    protected abstract val dataBindingVariable: Int?
    protected abstract val viewModel: BaseViewModel
    protected abstract fun diComponent(): UIComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModelFactory = createViewModelFactory()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    final override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(viewModel)
        dataBindingVariable?.let { binding?.setVariable(it, viewModel) }
        binding?.lifecycleOwner = viewLifecycleOwner

        viewModel.events.observe(viewLifecycleOwner) { it.execute(this) }
    }

    private fun createViewModelFactory(): ViewModelProvider.Factory = with(diComponent()) {
        return@with viewModelFactory
    }

    inline fun <reified T : ViewModel> injectViewModel() = lazy {

        ViewModelProvider(this, viewModelFactory)[T::class.java]
    }
}