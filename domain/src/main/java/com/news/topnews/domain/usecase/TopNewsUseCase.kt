package com.news.topnews.domain.usecase

import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.TopNews
import kotlinx.coroutines.flow.Flow

/*
 * Use case Interface to use app module
 */
interface TopNewsUseCase {
    suspend fun getTopNews(page: Int): Flow<ResponseWrapper<TopNews>>
}