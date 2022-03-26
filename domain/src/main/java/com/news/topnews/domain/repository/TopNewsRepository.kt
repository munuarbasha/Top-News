package com.news.topnews.domain.repository

import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsResponse
import kotlinx.coroutines.flow.Flow

interface TopNewsRepository {
    suspend fun getTopNews() : Flow<ResponseWrapper<TopNewsResponse>>
}