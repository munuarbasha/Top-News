package com.news.topnews.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Top News response class
 */
@Parcelize
data class TopNewsEntity(
    val data: List<NewsDataEntity>,
    val meta: MetaEntiry
): Parcelable