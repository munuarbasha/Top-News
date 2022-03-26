package com.news.topnews.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.topnews.domain.common.ResponseWrapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {
    private val _splashStatus = MutableLiveData<ResponseWrapper<SplashState.SplashScreen>>()
    val splashStatus: LiveData<ResponseWrapper<SplashState.SplashScreen>> = _splashStatus

    init {
        _splashStatus.value = ResponseWrapper.Loading
        viewModelScope.launch {
            delay(timeMillis = 3000)
            val response = ResponseWrapper.Success(SplashState.SplashScreen)
            _splashStatus.postValue(response)
        }
    }

    sealed class SplashState {
        object SplashScreen
    }
}