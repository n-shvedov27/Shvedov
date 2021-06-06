package com.example.sirius.fragment.main

import com.example.sirius.R
import com.example.sirius.BR
import com.example.sirius.core.di.UIComponent
import com.example.sirius.core.ui.BaseFragment
import com.example.sirius.entity.ImageItem
import com.example.sirius.fragment.error.ErrorFragment
import com.example.sirius.fragment.page.PageFragment
import com.example.sirius.fragment.main.di.MainFragmentComponentHolder

class MainFragment : BaseFragment()  {

    override val layoutId = R.layout.fragment_main
    override val dataBindingVariable = BR.vmMainFragment
    override val viewModel: MainFragmentViewModel by injectViewModel()

    override fun diComponent(): UIComponent = MainFragmentComponentHolder.getComponent()

    fun showNextPageFragment(imageItem: ImageItem) {
        childFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_right_enter,
                R.animator.card_flip_right_exit
            )
            .replace(R.id.image_fragment, PageFragment.newInstance(imageItem))
            .commit()
    }

    fun showPreviousPageFragment(imageItem: ImageItem) {
        childFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_left_enter,
                R.animator.card_flip_left_exit
            )
            .replace(R.id.image_fragment, PageFragment.newInstance(imageItem))
            .commit()
    }

    fun showStartPageFragment(imageItem: ImageItem) {
        childFragmentManager.beginTransaction()
            .replace(R.id.image_fragment, PageFragment.newInstance(imageItem))
            .commit()
    }

    fun showErrorLoadingFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.image_fragment, ErrorFragment())
            .commit()
    }
}