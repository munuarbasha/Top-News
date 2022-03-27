package com.news.topnews.common.binding

import android.text.Spannable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.news.topnews.common.R

@BindingAdapter("app:loadImageUrl")
fun loadImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.img_news_placeholder)
        .into(imageView)
}

@BindingAdapter("app:textWithUnderline")
fun setTextWithUnderline(
    textView: TextView,
    text: String
) {
    val finalText = textView.context.getString(R.string.more_details, text)
    val spannableString = SpannableString(finalText)
    if (finalText.isNotBlank()) {
        spannableString.setSpan(
            UnderlineSpan(), 0,
            0 + finalText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    textView.text = spannableString
}