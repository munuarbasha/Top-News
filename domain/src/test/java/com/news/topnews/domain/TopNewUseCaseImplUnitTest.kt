package com.news.topnews.domain

import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.Meta
import com.news.topnews.domain.model.TopNews
import com.news.topnews.domain.repository.TopNewsRepository
import com.news.topnews.domain.usecase.TopNewsUseCase
import com.news.topnews.domain.usecaseimpl.TopNewsUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TopNewUseCaseImplUnitTest {

    @Mock
    lateinit var topNewsRepository: TopNewsRepository

    lateinit var topNewsUseCase: TopNewsUseCase

    @Before
    fun setUp() {
        topNewsUseCase = TopNewsUseCaseImpl(topNewsRepository)
    }

    @Test
    fun testTopNewsUseCase() {
        runBlocking {
            val mockResult =
                flowOf(ResponseWrapper.Success(TopNews(getNewsDomainModelList(), Meta(1))))
            Mockito.`when`(topNewsRepository.getTopNews(1)).thenReturn(mockResult)
            val useCaseData = topNewsUseCase.getTopNews(1).toList()
            assert(useCaseData.isNotEmpty())
        }
    }
}