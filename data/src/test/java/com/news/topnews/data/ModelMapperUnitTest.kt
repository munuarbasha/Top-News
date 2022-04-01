package com.news.topnews.data

import com.news.topnews.data.common.getNewsDataDtoList
import com.news.topnews.data.common.getNewsDomainModelList
import com.news.topnews.data.mapper.DataDtoToDomainModelMapper
import com.news.topnews.data.model.MetaDto
import com.news.topnews.data.model.TopNewsResponseDto
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.Meta
import com.news.topnews.domain.model.TopNews
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ModelMapperUnitTest {

    @Test
    fun testModelMapper() {

        val modelMapper = Mockito.mock(DataDtoToDomainModelMapper::class.java)

        val mockOutPutDomainModel = ResponseWrapper.Success(TopNews(getNewsDomainModelList(), Meta(1)))

        val mockInputDataModel = ResponseWrapper.Success(TopNewsResponseDto(getNewsDataDtoList(), MetaDto(1)))
        Mockito.`when`(modelMapper.map(mockInputDataModel)).thenReturn(mockOutPutDomainModel)

        val mappingResult = modelMapper.map(mockInputDataModel)

        val outPutDomainModel = (mappingResult as ResponseWrapper.Success).value
        Assert.assertEquals(outPutDomainModel.meta, mockOutPutDomainModel.value.meta)
    }

}