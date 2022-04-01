package com.news.topnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * Top News response model class
 */

data class TopNewsResponseDto(
    @SerializedName("data") val newsDataDto: List<NewsDataDto>,
    @SerializedName("meta") val metaDto: MetaDto
)