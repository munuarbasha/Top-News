package com.news.topnews.domain.usecase

import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsResponse
import kotlinx.coroutines.flow.Flow

interface TopNewsUseCase {
    suspend fun getTopNews(page: Int): Flow<ResponseWrapper<TopNewsResponse>>
}