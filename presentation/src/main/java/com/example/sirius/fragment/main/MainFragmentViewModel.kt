package com.example.sirius.fragment.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.domain.ImageRepository
import com.example.domain.use_case.get_image_by_index.GetImageByIndex
import com.example.sirius.core.vm.BaseViewModel
import com.example.sirius.fragment.main.event.StartPage
import com.example.sirius.fragment.main.event.ToNextPage
import com.example.sirius.fragment.main.event.ToPreviousPage
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(

    private val getImageByIndex: GetImageByIndex

) : BaseViewModel() {

    private val _isMoveToPreviousAvailable = MutableLiveData(false)
    val isMoveToPreviousAvailable : LiveData<Boolean> = _isMoveToPreviousAvailable
    private val _isLoadingVisible = MutableLiveData(false)
    val isLoadingVisible : LiveData<Boolean> = _isLoadingVisible

    private var currentPage = 0

    fun onNextClick() = launch {

        currentPage++
        val model = getImageByIndex.execute(currentPage)
        postViewEvents(ToNextPage(model.url))
        _isMoveToPreviousAvailable.value = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() = launch {

        val model = getImageByIndex.execute(currentPage)
        postViewEvents(StartPage(model.url))
    }


    fun onPreviousClick() = launch {

        currentPage--
        val model = getImageByIndex.execute(currentPage)
        postViewEvents(ToPreviousPage(model.url))
        _isMoveToPreviousAvailable.value = currentPage > 0
    }
}