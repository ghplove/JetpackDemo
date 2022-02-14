package com.ghp.databinding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ghp.databinding.data.DataBindingViewModel
import com.ghp.databinding.data.DataBindingViewModelFactory
import com.ghp.databinding.databinding.FragmentDatabindingBinding

class DatabindingFragment : Fragment() {

    private lateinit var dataBindingViewModel: DataBindingViewModel

//    private val dataBindingViewModel: DataBindingViewModel
//    by lazy {
//        ViewModelProvider(this, DataBindingViewModelFactory)[DataBindingViewModel::class.java].apply {
//            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
//        }
//    }

    //绑定类根据布局文件的名称，转换大小写+末尾添加 Binding 后缀
    private var _binding: FragmentDatabindingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindingViewModel = ViewModelProvider(this)[DataBindingViewModel::class.java].apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDatabindingBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.lifecycleOwner = this

        //绑定数据
        binding.viewmodel = dataBindingViewModel

//        dataBindingViewModel.isShowView.observe(viewLifecycleOwner, {
//            binding.imageview.isVisible = it
//        })
        return view
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int) =
            DatabindingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}