package com.example.sirius.core.vm

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sirius.core.event.ViewEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), LifecycleObserver, CoroutineScope {

    private val _events = MutableLiveData<ViewEvent>()
    val events: LiveData<ViewEvent> = _events

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + supervisorJob + defaultExceptionHandler

    private val supervisorJob = SupervisorJob()
    private val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->
        handleCoroutineException(exception)
    }

    private fun handleCoroutineException(exception: Throwable) {
        postViewEvents()
    }

    protected fun postViewEvents(vararg events: ViewEvent) = events.forEach(_events::setValue)
}