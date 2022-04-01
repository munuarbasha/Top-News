package com.news.topnews.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Top News response class
 */
@Parcelize
data class TopNews(
    val data: List<NewsData>,
    val meta: Meta
): Parcelable