package com.ghp.lifecycle.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.ghp.lifecycle.data.LifecycleViewModel
import com.ghp.lifecycle.data.MyObserver
import com.ghp.lifecycle.R
import kotlinx.android.synthetic.main.lifecycle_fragment.*

class LifecycleFragment : Fragment() {

    private val TAG = "LifecycleFragment"
//    private lateinit var viewModel: LifecycleViewModel
    private val viewModel: LifecycleViewModel
    by lazy{
        ViewModelProvider(this)[LifecycleViewModel::class.java].apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lifecycle_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewLifecycleOwner需在onCreateView之后，destroy之前
        viewLifecycleOwner.lifecycle.addObserver(MyObserver())
        viewModel.dataBindingTest.observe(viewLifecycleOwner, {
            index_text.text = it
        })
    }

    private fun enable() {
        //判断Lifecycle当前状态
        if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {

        }
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(sectionNumber: Int) =
            LifecycleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
    }

}