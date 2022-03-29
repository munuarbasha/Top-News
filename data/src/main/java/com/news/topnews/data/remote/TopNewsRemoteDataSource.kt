package com.news.topnews.data.remote

import com.news.topnews.data.service.ApiService
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.TopNewsResponse
import javax.inject.Inject

/**
 * DataSource of Top News List API service
 */
internal class TopNewsRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseApiResponse() {
    /**
     * This function is to get the top news list from TopNewsRemoteDataSource
     */
    suspend fun getTopNews(page: Int): ResponseWrapper<TopNewsResponse> {
        return getWrappedResponse { apiService.getTopNews(page = page) }
    }
}