package com.news.topnews.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Meta(
    val found: Int,
    val limit: Int,
    val page: Int,
    val returned: Int
):Parcelable