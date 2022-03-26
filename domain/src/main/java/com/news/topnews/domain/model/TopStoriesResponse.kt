package com.news.topnews.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class TopStoriesResponse(
    val data: List<Data>,
    val meta: Meta
): Parcelable