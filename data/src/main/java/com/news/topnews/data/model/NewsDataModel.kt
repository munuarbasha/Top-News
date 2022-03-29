package com.news.topnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * Entity class for news data
 */

data class NewsDataModel(
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("published_at") val publishedAt: String,
    @SerializedName("snippet") val snippet: String,
    @SerializedName("source") val source: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("uuid") val uuid: String
)