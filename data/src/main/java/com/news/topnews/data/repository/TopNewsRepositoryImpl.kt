package com.news.topnews.data.repository

import com.news.topnews.data.remote.TopNewsRemoteDataSource
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsResponse
import com.news.topnews.domain.repository.TopNewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class TopNewsRepositoryImpl @Inject constructor(private val remoteDataSource: TopNewsRemoteDataSource) :
    TopNewsRepository {
    override suspend fun getTopNews(page: Int): Flow<ResponseWrapper<TopNewsResponse>> {
        return flow {
            emit(ResponseWrapper.Loading)
            emit(remoteDataSource.getTopNews(page))
        }.flowOn(Dispatchers.IO)
    }
}