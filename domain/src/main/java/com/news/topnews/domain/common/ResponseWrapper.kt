package com.news.topnews.domain.common

import com.news.topnews.domain.model.ErrorResponse
/*
*  sealed class that represents the API call response states.
* */
sealed class ResponseWrapper<out T> {
    /**
     * Success response with body
     */
    data class Success<out T>(val value: T): ResponseWrapper<T>()
    /**
     * Indicate presenter to load progress
     */
    object Loading: ResponseWrapper<Nothing>()
    /**
     * Failure response with body
     */
    data class Error(val error: ErrorResponse? = null): ResponseWrapper<Nothing>()
}