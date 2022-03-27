package com.news.topnews.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class NewsData(
    val description: String = "",
    val image_url: String = "",
    val published_at: String = "",
    val snippet: String = "",
    val source: String = "",
    val title: String = "",
    val url: String = "",
    val uuid: String = ""
) : Parcelable