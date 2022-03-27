package com.news.topnews.data.remote

import com.news.topnews.data.service.ApiService
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsResponse
import javax.inject.Inject

class TopNewsRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseApiResponse() {

    suspend fun getTopNews(page: Int): ResponseWrapper<TopNewsResponse> {
        return getWrappedResponse { apiService.getTopNews(page = page) }
    }
}