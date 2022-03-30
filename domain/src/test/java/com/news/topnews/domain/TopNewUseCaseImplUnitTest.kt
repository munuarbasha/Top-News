package com.news.topnews.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.MetaEntiry
import com.news.topnews.domain.entity.TopNewsEntity
import com.news.topnews.domain.repository.TopNewsRepository
import com.news.topnews.domain.usecase.TopNewsUseCase
import com.news.topnews.domain.usecaseimpl.TopNewsUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TopNewUseCaseImplUnitTest {

    @get:Rule
    val testExecutorRule: TestRule = InstantTaskExecutorRule()

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
                flowOf(ResponseWrapper.Success(TopNewsEntity(getNewsEntityList(), MetaEntiry(1))))
            Mockito.`when`(topNewsRepository.getTopNews(1)).thenReturn(mockResult)
            val useCaseData = topNewsUseCase.getTopNews(1).toList()
            assert(useCaseData.isNotEmpty())
        }
    }
}