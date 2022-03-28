package com.news.topnews.common.extensions

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

/**
 * Extension for Views
 */
fun View.show() {
    if (!this.isVisible)
        this.visibility = View.VISIBLE
}

fun View.hide() {
    if (this.isVisible)
        this.visibility = View.GONE
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}