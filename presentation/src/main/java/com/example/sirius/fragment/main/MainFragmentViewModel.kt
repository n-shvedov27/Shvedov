package com.example.sirius.fragment.main

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.ImageRepository
import com.example.sirius.core.event.ViewEvent
import com.example.sirius.fragment.main.event.ToNextPage
import com.example.sirius.fragment.main.event.ToPreviousPage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainFragmentViewModel @Inject constructor(

    private val repository: ImageRepository

) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + supervisorJob + defaultExceptionHandler

    private val supervisorJob = SupervisorJob()
    private val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->
        handleCoroutineException(exception)
    }

    private val _events = MutableLiveData<ViewEvent>()
    val events: LiveData<ViewEvent> = _events
    private val _isMoveToPreviousAvailable = MutableLiveData(false)
    val isMoveToPreviousAvailable : LiveData<Boolean> = _isMoveToPreviousAvailable
    private val _isLoadingVisible = MutableLiveData(false)
    val isLoadingVisible : LiveData<Boolean> = _isLoadingVisible

    private var currentPage = 0

    fun onNextClick() = launch {

        val model = repository.loadNext()

        _events.value = ToNextPage(model.url)
        currentPage++
        _isMoveToPreviousAvailable.value = true
    }

    fun onPreviousClick() = launch {

        _events.value = ToPreviousPage("dawd")
        currentPage--
        _isMoveToPreviousAvailable.value = currentPage > 0
    }

    private fun handleCoroutineException(exception: Throwable) {

        Log.e("MY_DEBUG", "handleCoroutineException: ${exception.message}")

    }
}