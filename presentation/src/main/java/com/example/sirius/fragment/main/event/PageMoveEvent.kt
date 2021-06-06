package com.example.sirius.fragment.main.event

import androidx.fragment.app.Fragment
import com.example.sirius.core.event.ViewEvent
import com.example.sirius.fragment.main.MainFragment

sealed class PageMoveEvent : ViewEvent

class ToNextPage(private val url: String) : PageMoveEvent() {

    override fun execute(fragment: Fragment) {

        (fragment as? MainFragment)?.let { it.showNextPageFragment(url) }
    }
}

class ToPreviousPage(private val url: String) : PageMoveEvent() {

    override fun execute(fragment: Fragment) {

        (fragment as? MainFragment)?.let { it.showPreviousPageFragment(url) }
    }
}