package com.example.sirius.fragment.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.domain.use_case.get_image_by_index.GetImageByIndex
import com.example.sirius.core.vm.BaseViewModel
import com.example.sirius.fragment.main.event.StartPage
import com.example.sirius.fragment.main.event.ToNextPage
import com.example.sirius.fragment.main.event.ToPreviousPage
import com.example.sirius.mapper.ImageDomainToPresentationMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(

    private val getImageByIndex: GetImageByIndex,
    private val imageDomainToPresentationMapper: ImageDomainToPresentationMapper

) : BaseViewModel() {

    private val _isMoveToPreviousAvailable = MutableLiveData(false)
    val isMoveToPreviousAvailable : LiveData<Boolean> = _isMoveToPreviousAvailable

    var currentPage = 0

    fun onNextClick() = launch {

        currentPage++
        val model = getImageByIndex.execute(currentPage)
        postViewEvents(ToNextPage(model.run(imageDomainToPresentationMapper)))
        _isMoveToPreviousAvailable.value = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadCurrentPageData() = launch {

        val model = getImageByIndex.execute(currentPage)
        postViewEvents(StartPage(model.run(imageDomainToPresentationMapper)))
    }


    fun onPreviousClick() = launch {

        currentPage--
        val model = getImageByIndex.execute(currentPage)
        postViewEvents(ToPreviousPage(model.run(imageDomainToPresentationMapper)))
        _isMoveToPreviousAvailable.value = currentPage > 0
    }
}