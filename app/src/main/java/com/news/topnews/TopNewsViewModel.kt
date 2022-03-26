package com.news.topnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.TopNewsResponse
import com.news.topnews.domain.usecase.TopNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopNewsViewModel @Inject constructor(private val topNewsUseCase: TopNewsUseCase) :
    ViewModel() {

    private val _topNewsList = MutableLiveData<ResponseWrapper<TopNewsResponse>>()
    val topNewsList: LiveData<ResponseWrapper<TopNewsResponse>> = _topNewsList

    fun getTopNews() {
        viewModelScope.launch {
            topNewsUseCase.getTopNews().collect { response ->
                _topNewsList.value = response
            }
        }
    }
}