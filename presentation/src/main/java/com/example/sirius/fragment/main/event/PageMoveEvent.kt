package com.example.sirius.fragment.main.event

import androidx.fragment.app.Fragment
import com.example.sirius.core.event.ViewEvent
import com.example.sirius.entity.ImageItem
import com.example.sirius.fragment.main.MainFragment

sealed class PageMoveEvent : ViewEvent

class ToNextPage(private val imageItem: ImageItem) : PageMoveEvent() {

    override fun execute(fragment: Fragment) {

        (fragment as? MainFragment)?.let { it.showNextPageFragment(imageItem) }
    }
}

class ToPreviousPage(private val imageItem: ImageItem) : PageMoveEvent() {

    override fun execute(fragment: Fragment) {

        (fragment as? MainFragment)?.let { it.showPreviousPageFragment(imageItem) }
    }
}

class StartPage(private val imageItem: ImageItem) : PageMoveEvent() {

    override fun execute(fragment: Fragment) {

        (fragment as? MainFragment)?.let { it.showStartPageFragment(imageItem) }
    }
}