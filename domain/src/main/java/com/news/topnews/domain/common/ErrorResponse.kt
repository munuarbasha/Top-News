package com.news.topnews.domain.common
/**
 * common data class for all error response
 */
data class ErrorResponse(val errorMessage: String? = null, val errorCode: Int? = 0)