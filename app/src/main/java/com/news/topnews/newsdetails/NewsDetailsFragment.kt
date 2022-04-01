package com.news.topnews.newsdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.news.topnews.R
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.common.constants.CommonConstants
import com.news.topnews.databinding.FragmentNewsDetailsBinding
import com.news.topnews.domain.model.NewsData

/**
 * Fragment to display news details
 */
class NewsDetailsFragment : BaseBindingFragment<FragmentNewsDetailsBinding>() {
    private var newsData: NewsData? = null
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsDetailsBinding
        get() = FragmentNewsDetailsBinding::inflate

    override fun setUpView() {
        getArgumentData()
        initListener()
    }

    private fun initListener() {
        binding.tvMoreDetails.setOnClickListener {
            val bundle = bundleOf(CommonConstants.KEY_REDIRECTION_URL to newsData?.url)
            Navigation.findNavController(it)
                .navigate(R.id.action_to_topNewsDetailsWebFragment, bundle)
        }
    }

    private fun getArgumentData() {
        arguments?.let {
            if (it.containsKey(CommonConstants.KEY_NEWS_DATA)) {
                newsData = it.getParcelable(CommonConstants.KEY_NEWS_DATA)
                binding.newsData = newsData
            }
        }
    }
}