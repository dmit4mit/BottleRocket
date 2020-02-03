package com.android.bottlerocket.common

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

object UiUtil {
    @BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
    @JvmStatic
    fun loadImage(view: ImageView, imageUrl: String?, placeholder: Drawable? = null) {
        view.load(imageUrl) {
            this.placeholder(placeholder)
        }
    }
}