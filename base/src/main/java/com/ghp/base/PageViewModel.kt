package com.ghp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class PageViewModel : ViewModel() {

    var index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        this.index.value = index
    }
}