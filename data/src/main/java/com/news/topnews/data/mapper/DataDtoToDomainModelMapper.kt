package com.news.topnews.data.mapper

import com.news.topnews.data.model.MetaDto
import com.news.topnews.data.model.NewsDataDto
import com.news.topnews.data.model.TopNewsResponseDto
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.Meta
import com.news.topnews.domain.model.NewsData
import com.news.topnews.domain.model.TopNews
import javax.inject.Inject
/**
 * Class to Map Data layer model to Domain layer entity to make code separation
 */
internal class DataDtoToDomainModelMapper @Inject constructor() :
    Mapper<ResponseWrapper<TopNewsResponseDto>, ResponseWrapper<TopNews>> {
    override fun map(input: ResponseWrapper<TopNewsResponseDto>): ResponseWrapper<TopNews> =
        with(input) {
          val inputData =  (input as ResponseWrapper.Success).value
            ResponseWrapper.Success(
                TopNews(
                    mapDataNewsToDomainNews(inputData.newsDataDto),
                    mapDataMetaToDomainMeta(inputData.metaDto)
                )
            )
        }

    private fun mapDataNewsToDomainNews(dataList: List<NewsDataDto>?): List<NewsData> {
        return if (!dataList.isNullOrEmpty()) dataList.map { input ->
            NewsData(
                input.description,
                input.imageUrl,
                input.publishedAt,
                input.snippet,
                input.source,
                input.title,
                input.url,
                input.uuid
            )
        } else mutableListOf(NewsData())
    }

    private fun mapDataMetaToDomainMeta(metaDto: MetaDto?): Meta {
        return Meta(metaDto?.page ?: 0)
    }
}
