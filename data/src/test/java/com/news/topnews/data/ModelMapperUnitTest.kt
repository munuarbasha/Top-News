package com.news.topnews.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.news.topnews.data.common.getNewsDataList
import com.news.topnews.data.common.getNewsEntityList
import com.news.topnews.data.mapper.DataModelToDomainEntityMapper
import com.news.topnews.data.model.MetaData
import com.news.topnews.data.model.TopNewsResponseData
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.MetaEntiry
import com.news.topnews.domain.entity.TopNewsEntity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ModelMapperUnitTest {
    @get:Rule
    val testExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    internal lateinit var mapperFactory: DataModelToDomainEntityMapper

    @Before
    fun setUp() {
        mapperFactory = DataModelToDomainEntityMapper()
    }

    @Test
    fun testModelMapper() {

        val mockOutPutDomainEntity =
            ResponseWrapper.Success(TopNewsEntity(getNewsEntityList(), MetaEntiry(1)))

        val mockInputDataModel =
            ResponseWrapper.Success(TopNewsResponseData(getNewsDataList(), MetaData(1)))
        val mappingResult = mapperFactory.map(mockInputDataModel)

        val outPutEntity = (mappingResult as ResponseWrapper.Success).value
        assert(outPutEntity.meta.page == mockOutPutDomainEntity.value.meta.page)
    }

}