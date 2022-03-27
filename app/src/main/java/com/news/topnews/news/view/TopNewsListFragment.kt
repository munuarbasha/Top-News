package com.news.topnews.news.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.topnews.R
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.common.constants.CommonConstants
import com.news.topnews.databinding.FragmentTopNewsListBinding
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.domain.entity.NewsData
import com.news.topnews.news.adapter.TopNewsAdapter
import com.news.topnews.news.viewmodel.TopNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopNewsListFragment : BaseBindingFragment<FragmentTopNewsListBinding>() {
    private val viewModel by viewModels<TopNewsViewModel>()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTopNewsListBinding
        get() = FragmentTopNewsListBinding::inflate

    override fun setUpView() {
        initRecyclerView()
        initObserver()
    }

    private fun initRecyclerView() {
        binding.topNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private val onNewsClicked: (newsData: NewsData, itemView: View) -> Unit = { newsData, itemView ->
        val bundle = bundleOf(
            CommonConstants.KEY_NEWS_DATA to newsData,
        )
        Navigation.findNavController(itemView).navigate(R.id.action_to_topNewsDetailsFragment, bundle)
    }

    private fun initObserver() {
        viewModel.getTopNews()
        viewModel.topNewsList.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseWrapper.Loading -> showLoading()

                is ResponseWrapper.Success -> {
                    dismissLoading()
                    val topNewsAdapter = TopNewsAdapter(it.value.data, onNewsClicked)
                    binding.topNewsRecyclerView.adapter = topNewsAdapter
                }
                is ResponseWrapper.Error -> {

                }
            }
        }
    }

}