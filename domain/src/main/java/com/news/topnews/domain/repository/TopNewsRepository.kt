package com.news.topnews.domain.repository

import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsEntity
import kotlinx.coroutines.flow.Flow
/*
 * Repository Interface to implement in data module
 */
interface TopNewsRepository {
    suspend fun getTopNews(page: Int): Flow<ResponseWrapper<TopNewsEntity>>
}