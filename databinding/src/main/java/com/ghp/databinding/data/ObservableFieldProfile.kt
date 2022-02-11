package com.ghp.databinding.data

import androidx.databinding.ObservableInt

//数据对象 data
data class ObservableFieldProfile(
        val name: String,
        val lastName: String,
        val likes: ObservableInt
)
