package com.news.topnews.data

import com.news.topnews.data.common.getNewsDataList
import com.news.topnews.data.common.getNewsEntityList
import com.news.topnews.data.mapper.DataModelToDomainEntityMapper
import com.news.topnews.data.model.MetaData
import com.news.topnews.data.model.TopNewsResponseData
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.MetaEntiry
import com.news.topnews.domain.entity.TopNewsEntity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ModelMapperUnitTest {

    @Test
    fun testModelMapper() {

        val entityMapper = Mockito.mock(DataModelToDomainEntityMapper::class.java)

        val mockOutPutDomainEntity = ResponseWrapper.Success(TopNewsEntity(getNewsEntityList(), MetaEntiry(1)))

        val mockInputDataModel = ResponseWrapper.Success(TopNewsResponseData(getNewsDataList(), MetaData(1)))
        Mockito.`when`(entityMapper.map(mockInputDataModel)).thenReturn(mockOutPutDomainEntity)

        val mappingResult = entityMapper.map(mockInputDataModel)

        val outPutEntity = (mappingResult as ResponseWrapper.Success).value
        Assert.assertEquals(outPutEntity.meta, mockOutPutDomainEntity.value.meta)
    }

}