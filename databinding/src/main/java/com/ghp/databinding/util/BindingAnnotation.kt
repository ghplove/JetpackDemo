package com.ghp.databinding.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.databinding.*
import com.bumptech.glide.Glide
import com.ghp.databinding.BR
import com.ghp.databinding.R

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}

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

    @BindingAdapter("app:progressTint")
    @JvmStatic fun tintPopularity(view: ProgressBar, popularity: Popularity) {

        val color = getAssociatedColor(popularity, view.context)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.progressTintList = ColorStateList.valueOf(color)
        }
    }
    @BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
    @JvmStatic fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
        progressBar.progress = (likes * max / 20).coerceAtMost(max)
    }

//    //全局改变，慎用
//    //android:visibility="@{boolean}"
//    @BindingConversion
//    @JvmStatic fun booleanToVisibility(isNotVisible: Boolean): Int {
//        return if (isNotVisible) View.GONE else View.VISIBLE
//    }

}
private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
    return when (popularity) {
        Popularity.NORMAL -> context.theme.obtainStyledAttributes(
            intArrayOf(android.R.attr.colorForeground)).getColor(0, 0x000000)
        Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
        Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
    }
}

// 需添加'kotlin-kapt'
//自定义属性绑定方法
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

