package com.ghp.databinding.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.*
import com.bumptech.glide.Glide
import com.ghp.databinding.BR
import com.ghp.databinding.R

object BindingAnnotation {
    /**
     * BindingAdapter必须是static类型
     * requireAll默认是true
     * @BindingAdapter("imageUrl", "placeholder")
     */
    @BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = true)
    @JvmStatic
    fun loadImageFromUrl(view: ImageView,
                         url: String,
                         drawable: Drawable
    ) {
        Glide.with(view.context)
            .load(url)
            .placeholder(drawable)
            .into(view)
    }

}


// 需添加'kotlin-kapt'
@BindingMethods(
    BindingMethod(type = TestEditText::class,
        attribute = "bindingMethodToast",
        method = "showBindingMethodToast")
)
class TestEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {

    fun showBindingMethodToast(test: String?) {
        if(test.isNullOrEmpty())return
        Toast.makeText(context, test, Toast.LENGTH_SHORT).show()
    }
}

//可观察对象
// Bindable 和 notifyPropertyChanged 配合使用，会自动刷新view
class BindableTestModel: BaseObservable() {
    @get:Bindable
    var firstName: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }
}

