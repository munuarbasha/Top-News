package com.news.topnews.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Entity class for news data
 */
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