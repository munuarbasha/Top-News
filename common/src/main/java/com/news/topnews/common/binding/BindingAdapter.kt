package com.news.topnews.common.binding

import android.text.Spannable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.news.topnews.common.R
import com.news.topnews.common.constants.CommonConstants
import java.text.SimpleDateFormat
import java.util.*

/**
 * Binding Adapter function to load image url from layout
 */
@BindingAdapter("bind:loadImageUrl")
fun loadImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.img_news_placeholder)
        .into(imageView)
}

/**
 * Binding Adapter function to set text to textview with underline
 */
@BindingAdapter("bind:textWithUnderline")
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

/**
 * Binding Adapter function to set date text to textview with readable date format
 */
@BindingAdapter("bind:dateText")
fun setDateText(textView: TextView, dateStr: String) {
    val simpleDateFormat = SimpleDateFormat(CommonConstants.DATE_FORMAT_ISO, Locale.getDefault())
    val dateString: Date? = simpleDateFormat.parse(dateStr)
    dateString?.let {
        textView.text =
            SimpleDateFormat(CommonConstants.DATE_FORMAT_E_DD_MMM_YYY, Locale.getDefault()).format(
                it
            ).toString()
    }

}