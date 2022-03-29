package com.news.topnews.data.remote

import com.news.topnews.data.model.TopNewsResponseData
import com.news.topnews.data.service.ApiService
import com.news.topnews.domain.common.ResponseWrapper
import javax.inject.Inject

/**
 * DataSource of Top News List API service
 */
internal class TopNewsRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseApiResponse() {
    /**
     * This function is to get the top news list from TopNewsRemoteDataSource
     */
    suspend fun getTopNews(page: Int): ResponseWrapper<TopNewsResponseData> {
        return getWrappedResponse { apiService.getTopNews(page = page) }
    }
}