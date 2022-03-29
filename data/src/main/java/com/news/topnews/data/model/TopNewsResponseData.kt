package com.news.topnews.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Top News response class
 */
@Parcelize
data class TopNewsResponseData(
    val data: List<NewsDataModel>,
    val meta: MetaData
): Parcelable