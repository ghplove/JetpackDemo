package com.ghp.databinding.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object DataBindingViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DataBindingViewModel::class.java)){
            return DataBindingViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}