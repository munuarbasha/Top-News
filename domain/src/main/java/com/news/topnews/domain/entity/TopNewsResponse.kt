package com.news.topnews.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class TopNewsResponse(
    val data: List<Data>,
    val meta: Meta
): Parcelable