package com.example.testshoppingmarket.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.testshoppingmarket.R

object ImageLoader {

    fun loadImage(
        view: ImageView,
        url: String,
        placeholder: Int = R.drawable.ic_baseline_image_24
    ) {
        Glide.with(view)
            .load(url)
            .placeholder(placeholder)
            .error(placeholder)
            .fallback(placeholder)
            .into(view)
    }
}