package com.news.topnews.data.repository

import com.news.topnews.data.mapper.DataModelToDomainEntityMapper
import com.news.topnews.data.remote.TopNewsRemoteDataSource
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsEntity
import com.news.topnews.domain.repository.TopNewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Repository Implementation class for TopNewsRepository interface from Domain Module
 */
internal class TopNewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: TopNewsRemoteDataSource,
    private var mapper: DataModelToDomainEntityMapper
) :
    TopNewsRepository {
    override suspend fun getTopNews(page: Int): Flow<ResponseWrapper<TopNewsEntity>> {
        return flow {
            emit(ResponseWrapper.Loading)
            emit(remoteDataSource.getTopNews(page).let(mapper::map))
        }.flowOn(Dispatchers.IO)
    }
}