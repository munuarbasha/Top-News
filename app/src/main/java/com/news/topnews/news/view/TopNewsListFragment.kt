package com.news.topnews.news.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news.topnews.R
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.common.constants.CommonConstants
import com.news.topnews.common.utils.AlertDialogUtils
import com.news.topnews.common.views.PaginationListener
import com.news.topnews.databinding.FragmentTopNewsListBinding
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.NewsData
import com.news.topnews.news.adapter.TopNewsAdapter
import com.news.topnews.news.viewmodel.TopNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * News List Fragment to display list of news
 */
@AndroidEntryPoint
class TopNewsListFragment : BaseBindingFragment<FragmentTopNewsListBinding>() {
    private lateinit var topNewsAdapter: TopNewsAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val viewModel by viewModels<TopNewsViewModel>()
    private lateinit var paginationListener: PaginationListener
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTopNewsListBinding
        get() = FragmentTopNewsListBinding::inflate

    override fun setUpView() {
        initRecyclerView()
        initObserver()
    }

    private fun initRecyclerView() {
        linearLayoutManager = LinearLayoutManager(requireContext())
        topNewsAdapter = TopNewsAdapter(onNewsClicked = onNewsClicked)
        paginationListener = object : PaginationListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                if (page > 1)
                    viewModel.getTopNews(page)
            }
        }

        binding.topNewsRecyclerView.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            addOnScrollListener(paginationListener)
            adapter = topNewsAdapter
        }
    }


    private val onNewsClicked: (newsData: NewsData, itemView: View) -> Unit =
        { newsData, itemView ->
            val bundle = bundleOf(
                CommonConstants.KEY_NEWS_DATA to newsData,
            )
            Navigation.findNavController(itemView)
                .navigate(R.id.action_to_topNewsDetailsFragment, bundle)
        }

    private fun initObserver() {
        viewModel.getTopNews()
        viewModel.topNewsList.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseWrapper.Loading -> showLoading()
                is ResponseWrapper.Success -> {
                    dismissLoading()
                    if (it.value.meta.page == 1) {
                        topNewsAdapter.list = it.value.data
                    } else {
                        topNewsAdapter.addList(it.value.data)
                    }
                    paginationListener.setLoading(false)
                }
                is ResponseWrapper.Error -> {
                    AlertDialogUtils.showError(
                        requireContext(),
                        it.error?.errorMessage
                    )
                }
            }
        }
    }

}