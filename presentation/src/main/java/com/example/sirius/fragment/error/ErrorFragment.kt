package com.example.sirius.fragment.error

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.sirius.R
import com.example.sirius.fragment.main.MainFragmentViewModel

class ErrorFragment : Fragment() {

    private val viewModel: MainFragmentViewModel by viewModels({requireParentFragment()})

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.view_error_fragment_repeat_button).setOnClickListener {
            viewModel.loadCurrentPageData()
        }
    }
}