package com.news.topnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * Top News response model class
 */

data class TopNewsResponseData(
    @SerializedName("data") val newsDataModel: List<NewsDataModel>,
    @SerializedName("meta") val meta: MetaData
)