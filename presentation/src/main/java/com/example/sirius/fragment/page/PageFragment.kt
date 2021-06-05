package com.example.sirius.fragment.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.domain.SearchType
import com.example.sirius.R
import com.example.sirius.core.di.UIComponent
import com.example.sirius.core.ui.BaseFragment
import com.example.sirius.fragment.image.ImageFragment
import com.example.sirius.fragment.page.di.PageFragmentComponentHolder

private const val SEARCH_TYPE = "search_type"

class PageFragment : BaseFragment()  {

    private lateinit var searchType: SearchType

    companion object {
        @JvmStatic fun newInstance(param1: SearchType) = PageFragment().apply {
            arguments = Bundle().apply { putSerializable(SEARCH_TYPE, param1) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { searchType = it.getSerializable(SEARCH_TYPE) as SearchType }
    }

    private val viewModel: PageFragmentViewModel by injectViewModel()

    override fun diComponent(): UIComponent = PageFragmentComponentHolder.getComponent()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.image_fragment, ImageFragment())
                .commit()

        }

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {

            childFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.animator.card_flip_right_enter,
                    R.animator.card_flip_right_exit,
                    R.animator.card_flip_left_enter,
                    R.animator.card_flip_left_exit
                )
                .replace(R.id.image_fragment, ImageFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}