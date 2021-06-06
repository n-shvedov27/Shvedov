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
                R.anim.enter_from_left,
                R.anim.enter_from_right
            )
            .replace(R.id.image_fragment, PageFragment.newInstance(imageItem))
            .commit()
    }

    fun showPreviousPageFragment(imageItem: ImageItem) {
        childFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.exit_from_right,
                R.anim.exit_from_left
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