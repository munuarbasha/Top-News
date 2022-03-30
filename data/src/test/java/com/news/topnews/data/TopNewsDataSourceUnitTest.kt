package com.news.topnews.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.news.topnews.data.common.getNewsDataList
import com.news.topnews.data.model.MetaData
import com.news.topnews.data.model.TopNewsResponseData
import com.news.topnews.data.remote.TopNewsRemoteDataSource
import com.news.topnews.data.service.ApiService
import com.news.topnews.data.utils.ApiConfig
import com.news.topnews.domain.common.ResponseWrapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.exceptions.base.MockitoException
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TopNewsDataSourceUnitTest {
    @get:Rule
    val testExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService

    private lateinit var remoteDataSource: TopNewsRemoteDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        remoteDataSource = TopNewsRemoteDataSource(apiService)
    }

    @Test
    fun topNewsSuccessResponse() {
        runBlocking {
            val mockResult = TopNewsResponseData(getNewsDataList(), MetaData(1))
            `when`(apiService.getTopNews(page = 1)).thenReturn(mockResult)
            val topNewsList = remoteDataSource.getTopNews(1)
            val dataSourceResult = (topNewsList as ResponseWrapper.Success).value

            assert(dataSourceResult.newsDataModel.size == mockResult.newsDataModel.size)
        }
    }

    @Test
    fun topNewsFailureResponse() = runBlocking {
        val mockitoException = MockitoException(ApiConfig.GENERIC_ERROR_MESSAGE)
        `when`(apiService.getTopNews(page = 1)).thenThrow(mockitoException)
        val result = remoteDataSource.getTopNews(1)
        val errorResponse = (result as ResponseWrapper.Error).error
        assert(errorResponse?.errorMessage == mockitoException.message)
    }

}