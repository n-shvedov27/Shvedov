package com.example.sirius.fragment.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sirius.R
import com.example.sirius.core.di.UIComponent
import com.example.sirius.core.ui.BaseFragment
import com.example.sirius.fragment.image.di.ImageFragmentComponentHolder

class ImageFragment : BaseFragment() {

    private val url = "http://static.devli.ru/public/images/gifs/202004/29a0483d-85ad-464b-b288-467844de3ee1.gif"

    private val viewModel: ImageFragmentViewModel by injectViewModel()

    override fun diComponent(): UIComponent = ImageFragmentComponentHolder.getComponent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadUrl(url)
    }
}