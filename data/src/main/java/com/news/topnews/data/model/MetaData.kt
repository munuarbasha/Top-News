package com.news.topnews.data.model

import com.google.gson.annotations.SerializedName


data class MetaData(
    @SerializedName("page") val page: Int,
)