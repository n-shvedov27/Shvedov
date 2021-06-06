package com.example.sirius.fragment.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.sirius.R

private const val URL_PARAM = "param2"

class PageFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance(url: String) = PageFragment().apply {
            arguments = Bundle().apply { putString(URL_PARAM, url) }
        }
    }

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { url = it.getString(URL_PARAM) }
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

        val imageView = view.findViewById<ImageView>(R.id.imageView)

        Glide.with(this).load(url)
            .thumbnail(
                Glide.with(this).load(R.drawable.loader)
            )
            .fitCenter()
            .into(imageView)
    }
}