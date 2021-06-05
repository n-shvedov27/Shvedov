package com.example.sirius.screen.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.sirius.R
import com.example.sirius.screen.page.PageFragment

class MainFragment : Fragment() {

    lateinit var pager: ViewPager
    lateinit var pagerAdapter: SimplePagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pager = view.findViewById(R.id.pager)
        pagerAdapter = SimplePagerAdapter(
            fm = childFragmentManager,
            pages = listOf(
                "Последние" to PageFragment(),
                "Лучшие" to PageFragment(),
                "Горячие" to PageFragment()
            )
        )
        pager.adapter = pagerAdapter
    }
}