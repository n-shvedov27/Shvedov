package com.example.sirius.core.event

import androidx.fragment.app.Fragment

interface ViewEvent {

    fun execute(fragment: Fragment)
}

