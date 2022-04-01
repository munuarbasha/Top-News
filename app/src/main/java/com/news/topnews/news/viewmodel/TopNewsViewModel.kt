package com.news.topnews.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.news.topnews.common.base.BaseViewModel
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.TopNews
import com.news.topnews.domain.usecase.TopNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class to get top news
 * @param topNewsUseCase
 */
@HiltViewModel
class TopNewsViewModel @Inject constructor(private val topNewsUseCase: TopNewsUseCase) :
    BaseViewModel() {

    private val _topNewsList = MutableLiveData<ResponseWrapper<TopNews>>()
    val topNewsList: LiveData<ResponseWrapper<TopNews>> = _topNewsList
    /**
     * Function to get top news
     * @param page - page number for query param
     */
    fun getTopNews(page: Int = 1) {
        viewModelScope.launch {
            topNewsUseCase.getTopNews(page).collect { response ->
                _topNewsList.value = response
            }
        }

    }
}