package com.news.topnews.data.remote

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.ErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * Class to handle API response with Success or failure to make Safe API calls
 */
abstract class BaseApiResponse {
    suspend fun <T> getWrappedResponse(apiCall: suspend () -> T): ResponseWrapper<T> {
        return withContext(Dispatchers.IO) {
            try {
                ResponseWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        val errorResponse = getErrorResponse(throwable)
                        ResponseWrapper.Error(errorResponse)
                    }
                    else -> {
                        ResponseWrapper.Error(ErrorResponse())
                    }
                }
            }
        }
    }

    private fun getErrorResponse(throwable: HttpException): ErrorResponse? {
        return try {
            throwable.response()?.errorBody()?.string()?.let {
                val errorRes = it
                val type = object : TypeToken<ErrorResponse>() {}.type
                val errorResponse: ErrorResponse? = Gson().fromJson(errorRes, type)
                errorResponse
            }
        } catch (exception: Exception) {
            ErrorResponse()
        }
    }
}
