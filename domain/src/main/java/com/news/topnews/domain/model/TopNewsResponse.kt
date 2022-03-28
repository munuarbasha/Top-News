package com.news.topnews.domain.model

import android.os.Parcelable
import com.news.topnews.domain.entity.Meta
import com.news.topnews.domain.entity.NewsData
import kotlinx.parcelize.Parcelize

/**
 * Top News response class
 */
@Parcelize
data class TopNewsResponse(
    val data: List<NewsData>,
    val meta: Meta
): Parcelable