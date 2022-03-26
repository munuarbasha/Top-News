package com.news.topnews.data.service

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/news/top")
    suspend fun getTopStories(
        @Query("language") language: String,
        @Query("locale") locale: String,
        @Query("api_token") apiToken: String,
    ): Response
}