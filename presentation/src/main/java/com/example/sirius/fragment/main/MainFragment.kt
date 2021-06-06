package com.example.sirius.fragment.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.sirius.R
import com.example.sirius.BR
import com.example.sirius.core.di.UIComponent
import com.example.sirius.core.ui.BaseFragment
import com.example.sirius.fragment.page.PageFragment
import com.example.sirius.fragment.main.di.MainFragmentComponentHolder

class MainFragment : BaseFragment()  {

    override val layoutId = R.layout.fragment_main
    override val dataBindingVariable = BR.vmMainFragment
    override val viewModel: MainFragmentViewModel by injectViewModel()

    override fun diComponent(): UIComponent = MainFragmentComponentHolder.getComponent()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner) { it.execute(this) }
    }

    fun showNextPageFragment(url: String) {
        childFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_right_enter,
                R.animator.card_flip_right_exit
            )
            .replace(R.id.image_fragment, PageFragment.newInstance(url))
            .commit()
    }

    fun showPreviousPageFragment(url: String) {
        childFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_left_enter,
                R.animator.card_flip_left_exit
            )
            .replace(R.id.image_fragment, PageFragment.newInstance(url))
            .commit()
    }
}