package com.news.topnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * data class for meta response
 */
data class MetaDto(
    @SerializedName("page") val page: Int,
)