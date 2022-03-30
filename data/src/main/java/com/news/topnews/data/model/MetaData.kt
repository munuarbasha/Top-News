package com.news.topnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * data class for meta response
 */
data class MetaData(
    @SerializedName("page") val page: Int,
)