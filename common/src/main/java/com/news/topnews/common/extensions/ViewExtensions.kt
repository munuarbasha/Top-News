package com.news.topnews.common.extensions

import android.view.View
import androidx.core.view.isVisible

/**
 * Extension for Views
 */
fun View.show() {
    if (!this.isVisible)
        this.visibility = View.VISIBLE
}