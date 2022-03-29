package com.news.topnews.data.mapper

import com.news.topnews.data.model.MetaData
import com.news.topnews.data.model.NewsDataModel
import com.news.topnews.data.model.TopNewsResponseData
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.MetaEntiry
import com.news.topnews.domain.entity.NewsDataEntity
import com.news.topnews.domain.entity.TopNewsEntity
import javax.inject.Inject
/**
 * Class to Map Data layer model to Domain layer entity to make code separation
 */
internal class DataModelToDomainEntityMapper @Inject constructor() :
    Mapper<ResponseWrapper<TopNewsResponseData>, ResponseWrapper<TopNewsEntity>> {
    override fun map(input: ResponseWrapper<TopNewsResponseData>): ResponseWrapper<TopNewsEntity> =
        with(input) {
          val inputData =  (input as ResponseWrapper.Success).value
            ResponseWrapper.Success(
                TopNewsEntity(
                    mapDataNewsToDomainNews(inputData.data),
                    mapDataMetaToDomainMeta(inputData.meta)
                )
            )
        }

    private fun mapDataNewsToDomainNews(dataList: List<NewsDataModel>?): List<NewsDataEntity> {
        return if (!dataList.isNullOrEmpty()) dataList.map { input ->
            NewsDataEntity(
                input.description,
                input.image_url,
                input.published_at,
                input.snippet,
                input.source,
                input.title,
                input.url,
                input.uuid
            )
        } else mutableListOf(NewsDataEntity())
    }

    private fun mapDataMetaToDomainMeta(meta: MetaData?): MetaEntiry {
        return MetaEntiry(meta?.page ?: 0)
    }
}
