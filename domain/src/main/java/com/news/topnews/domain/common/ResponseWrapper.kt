package com.news.topnews.domain.common

import com.news.topnews.domain.entity.ErrorResponse

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val value: T): ResponseWrapper<T>()
    object Loading: ResponseWrapper<Nothing>()
    data class Error(val error: ErrorResponse? = null): ResponseWrapper<Nothing>()
}