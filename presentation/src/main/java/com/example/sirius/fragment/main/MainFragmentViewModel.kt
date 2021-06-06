package com.example.sirius.fragment.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.domain.ImageRepository
import com.example.sirius.core.vm.BaseViewModel
import com.example.sirius.fragment.main.event.StartPage
import com.example.sirius.fragment.main.event.ToNextPage
import com.example.sirius.fragment.main.event.ToPreviousPage
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(

    private val repository: ImageRepository

) : BaseViewModel() {

    private val _isMoveToPreviousAvailable = MutableLiveData(false)
    val isMoveToPreviousAvailable : LiveData<Boolean> = _isMoveToPreviousAvailable
    private val _isLoadingVisible = MutableLiveData(false)
    val isLoadingVisible : LiveData<Boolean> = _isLoadingVisible

    private var currentPage = 0

    fun onNextClick() = launch {

        val model = repository.loadNext()

        postViewEvents(ToNextPage(model.url))
        currentPage++
        _isMoveToPreviousAvailable.value = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() = launch {

        val model = repository.loadNext()
        postViewEvents(StartPage(model.url))
    }


    fun onPreviousClick() = launch {

        postViewEvents(ToPreviousPage("dawd"))
        currentPage--
        _isMoveToPreviousAvailable.value = currentPage > 0
    }
}