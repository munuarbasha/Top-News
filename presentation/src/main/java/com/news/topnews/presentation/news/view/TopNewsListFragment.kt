package com.news.topnews.presentation.news.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.common.constants.CommonConstants
import com.news.topnews.common.utils.AlertDialogUtils
import com.news.topnews.common.views.PaginationListener
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.model.NewsData
import com.news.topnews.domain.model.TopNews
import com.news.topnews.presentation.R
import com.news.topnews.presentation.databinding.FragmentTopNewsListBinding
import com.news.topnews.presentation.news.adapter.TopNewsAdapter
import com.news.topnews.presentation.news.viewmodel.TopNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * News List Fragment to display list of news
 */
@AndroidEntryPoint
class TopNewsListFragment : BaseBindingFragment<FragmentTopNewsListBinding>() {
    private lateinit var topNewsAdapter: TopNewsAdapter
    private val topNewsViewModel by viewModels<TopNewsViewModel>()
    private lateinit var paginationListener: PaginationListener
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTopNewsListBinding
        get() = FragmentTopNewsListBinding::inflate

    override fun setUpView() {
        initRecyclerView()
        initObserver()
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        topNewsAdapter = TopNewsAdapter(onNewsItemClicked = onNewsItemClicked)
        paginationListener = object : PaginationListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                // When new data needs to be appended to the list
                if (page > 1)
                    topNewsViewModel.getTopNews(page)
            }
        }

        binding.rvTopNews.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            addOnScrollListener(paginationListener)
            adapter = topNewsAdapter
        }
    }

    private val onNewsItemClicked: (newsData: NewsData, itemView: View) -> Unit =
        { newsData, itemView ->
            val bundle = bundleOf(CommonConstants.KEY_NEWS_DATA to newsData)
            Navigation.findNavController(itemView)
                .navigate(R.id.action_to_topNewsDetailsFragment, bundle)
        }

    private fun initObserver() {
        topNewsViewModel.getTopNews()
        topNewsViewModel.topNewsList.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseWrapper.Loading -> showLoading()
                is ResponseWrapper.Success -> {
                    dismissLoading()
                    updateAdapter(it.value)
                }
                is ResponseWrapper.Error -> {
                    AlertDialogUtils.showError(requireContext(), it.error?.errorMessage)
                }
            }
        }
    }

    private fun updateAdapter(topNewsEntity: TopNews) {
        if (topNewsEntity.meta.page == 1) {
            topNewsAdapter.newsStoryList = topNewsEntity.data
        } else {
            topNewsAdapter.addList(topNewsEntity.data)
        }
        paginationListener.setLoading(false)
    }

}