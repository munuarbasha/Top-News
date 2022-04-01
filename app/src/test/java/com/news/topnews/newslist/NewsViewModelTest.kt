package com.news.topnews.newslist

import com.news.topnews.base.BaseVMTest
import com.news.topnews.common.getOrAwaitValue
import com.news.topnews.common.runBlockingTest
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.Meta
import com.news.topnews.domain.model.NewsData
import com.news.topnews.domain.model.TopNews
import com.news.topnews.domain.usecase.TopNewsUseCase
import com.news.topnews.news.viewmodel.TopNewsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class NewsViewModelTest : BaseVMTest() {


    // Subject under test
    private lateinit var viewModel: TopNewsViewModel

    // mock TopNewsUseCase to use with TopNewsViewModel
    @Mock
    private lateinit var useCase: TopNewsUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = TopNewsViewModel(useCase)
    }

    @Test
    fun testGetTopNews() {
        testCoroutineRule.runBlockingTest {
            val topNewsResponse = TopNews(getNewsDataList(), Meta(1))
            val mockResult =
                doReturn(flowOf(ResponseWrapper.Success(topNewsResponse))).`when`(useCase).getTopNews(page = 1)
            viewModel.getTopNews(1)
            Assert.assertEquals(viewModel.topNewsList.getOrAwaitValue(), mockResult)

        }
    }

    private fun getNewsDataList() = mutableListOf(
        NewsData(
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
            "mock"
        )
    )
}