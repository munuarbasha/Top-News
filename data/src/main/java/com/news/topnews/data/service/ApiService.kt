package com.news.topnews.data.service

import com.news.topnews.data.utils.ApiConfig
import com.news.topnews.domain.entity.TopNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ApiConfig.TOP_NEWS_ENDPOINT)
    suspend fun getTopNews(
        @Query("language") language: String = ApiConfig.DEFAULT_LANGUAGE,
        @Query("locale") locale: String = ApiConfig.DEFAULT_LOCALE,
        @Query("api_token") apiToken: String = ApiConfig.API_TOKEN,
    ): TopNewsResponse
}