package com.ghp.lifecycle.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LifecycleViewModel : ViewModel() {
    val dataBindingTest = MutableLiveData("test")
    fun setIndex(index: Int) {
        this.dataBindingTest.value = "Hello world from section: $index"
    }
}