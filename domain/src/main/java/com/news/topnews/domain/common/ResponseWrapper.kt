package com.news.topnews.domain.common

/*
*  sealed class that represents the API call response states.
* */
sealed class ResponseWrapper<out T> (
    val data: T? = null,
    val message: String? = null
){
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