package com.news.topnews.domain.usecaseimpl

import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsResponse
import com.news.topnews.domain.repository.TopNewsRepository
import com.news.topnews.domain.usecase.TopNewsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TopNewsUseCaseImpl @Inject constructor(private val repository: TopNewsRepository) :
    TopNewsUseCase {
    override suspend fun getTopNews(): Flow<ResponseWrapper<TopNewsResponse>> {
        return repository.getTopNews()
    }
}