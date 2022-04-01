package com.news.topnews.data

import com.news.topnews.data.common.getNewsDataDtoList
import com.news.topnews.data.mapper.DataDtoToDomainModelMapper
import com.news.topnews.data.model.MetaDto
import com.news.topnews.data.model.TopNewsResponseDto
import com.news.topnews.data.remote.TopNewsRemoteDataSource
import com.news.topnews.data.repository.TopNewsRepositoryImpl
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.repository.TopNewsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TopNewsRepositoryUnitTest {

    private lateinit var topNewsRepository: TopNewsRepository

    @Mock
    internal lateinit var remoteDataSource: TopNewsRemoteDataSource

    @Mock
    internal lateinit var modelMapper: DataDtoToDomainModelMapper


    @Before
    fun setUp() {
        topNewsRepository = TopNewsRepositoryImpl(remoteDataSource, modelMapper)
    }

    @Test
    fun testTopNewsRepository() {
        runBlocking {
            val topNewsResponse = TopNewsResponseDto(getNewsDataDtoList(), MetaDto(1))
            val topNewsResult = ResponseWrapper.Success(topNewsResponse)
            `when`(remoteDataSource.getTopNews(page = 1)).thenReturn(topNewsResult)
            val responseFlow = topNewsRepository.getTopNews(page = 1).toList()
            assert(responseFlow.size == 2)
        }
    }
}