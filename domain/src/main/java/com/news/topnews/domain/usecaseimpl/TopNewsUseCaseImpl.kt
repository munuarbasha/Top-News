package com.news.topnews.domain.usecaseimpl

import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.TopNewsResponse
import com.news.topnews.domain.repository.TopNewsRepository
import com.news.topnews.domain.usecase.TopNewsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
/*
 * Use case implementation class
 */
internal class TopNewsUseCaseImpl @Inject constructor(private val repository: TopNewsRepository) :
    TopNewsUseCase {
    override suspend fun getTopNews(page: Int): Flow<ResponseWrapper<TopNewsResponse>> {
        return repository.getTopNews(page)
    }
}