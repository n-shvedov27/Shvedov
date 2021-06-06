package com.example.sirius.core.event

import androidx.fragment.app.Fragment
import com.example.sirius.fragment.main.MainFragment

object Error : ViewEvent {

    override fun execute(fragment: Fragment) {
        (fragment as? MainFragment)?.showErrorLoadingFragment()
    }
}