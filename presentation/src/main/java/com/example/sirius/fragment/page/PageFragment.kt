package com.example.sirius.fragment.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.sirius.R
import com.example.sirius.entity.ImageItem

private const val IMAGE_ITEM_PARAM = "image_item_param"

class PageFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance(imageItem: ImageItem) = PageFragment().apply {
            arguments = Bundle().apply { putParcelable(IMAGE_ITEM_PARAM, imageItem) }
        }
    }

    private var imageItem: ImageItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { imageItem = it.getParcelable(IMAGE_ITEM_PARAM) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.view_page_fragment_image)
        view.findViewById<TextView>(R.id.view_page_fragment_description).text = imageItem?.description

        Glide.with(this).load(imageItem?.url)
            .thumbnail(Glide.with(this).load(R.drawable.loader))
            .fitCenter()
            .into(imageView)
    }
}