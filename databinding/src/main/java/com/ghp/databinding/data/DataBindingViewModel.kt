package com.ghp.databinding.data

import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.ghp.databinding.R
import com.ghp.databinding.util.BindableTestModel
import com.ghp.databinding.util.ObservableViewModel

class DataBindingViewModel : ObservableViewModel() {

    val dataBindingTest = MutableLiveData("test")
    val bindableTestModel = BindableTestModel()

    fun setIndex(index: Int) {
        this.dataBindingTest.value = "Hello world from section: $index"
    }

    //BindingMethods test
    val editTextStr = ObservableField("")

    //BindingAdapter test
    val bindingAdapterImageUrl = MutableLiveData("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fww3.sinaimg.cn%2Fmw690%2F71b89a12gy1gz51ovv9zpj20zk144go4.jpg&refer=http%3A%2F%2Fwww.sina.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1647153265&t=a2b323af7e5fea6424e893f8518de562")
    val bindingAdapterImagePlaceholder = R.mipmap.image_placeholder

    //Bindable test
    fun imageClick(view: View) {
        bindableTestModel.firstName = "bindableTestModel"
        Toast.makeText(view.context, "imageClick", Toast.LENGTH_SHORT).show()
    }

    //click test
    fun onButtonClick(view: View){
        Toast.makeText(view.context, "onButtonClick", Toast.LENGTH_SHORT).show()
    }

    //需要是可观察的，view绑定才会跟随变更
    val showImgView = ObservableBoolean(true)
    /**
     * MutableLiveData需要添加observe才可以更改view状态
     * 2种方式：
     * 1 主动添加observe，isShowView.observe(viewLifecycleOwner, {}）
     * 2 binding.lifecycleOwner = this
     */
    val isShowImgView = MutableLiveData(true)
    fun onCheckChanged(buttonView: View, isChecked: Boolean) {
        showImgView.set(isChecked)
        isShowImgView.value = isChecked
        Toast.makeText(buttonView.context, "onCheckChanged isChecked $isChecked", Toast.LENGTH_SHORT).show()
    }
}