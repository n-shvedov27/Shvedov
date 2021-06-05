package com.example.sirius.screen.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SimplePagerAdapter (

    fm: FragmentManager,
    private val pages: List<Pair<String, Fragment>>

) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return pages[position].second
    }

    override fun getPageTitle(position: Int): CharSequence {
        return pages[position].first
    }
}