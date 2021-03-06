package com.news.topnews.presentation.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.news.topnews.common.base.BaseViewModel
import com.news.topnews.domain.common.ResponseWrapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : BaseViewModel() {
    private val _splashStatus = MutableLiveData<ResponseWrapper<Boolean>>()
    val splashStatus: LiveData<ResponseWrapper<Boolean>> = _splashStatus

    init {
        loadSplashScreen()
    }

    fun loadSplashScreen() {
        viewModelScope.launch {
            _splashStatus.value = ResponseWrapper.Loading
            delay(timeMillis = 3000)
            val isFinishLoading = true
            val response = ResponseWrapper.Success(isFinishLoading)
            _splashStatus.postValue(response)
        }
    }
}