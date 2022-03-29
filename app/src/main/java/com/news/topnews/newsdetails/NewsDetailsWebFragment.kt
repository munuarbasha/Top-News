package com.news.topnews.newsdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.common.constants.CommonConstants
import com.news.topnews.databinding.FragmentNewsDetailsWebBinding

/**
 * Fragment to load url in Web view
 */
class NewsDetailsWebFragment : BaseBindingFragment<FragmentNewsDetailsWebBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsDetailsWebBinding
        get() = FragmentNewsDetailsWebBinding::inflate

    override fun setUpView() {
        getArgumentData()
    }

    private fun getArgumentData() {
        arguments?.let {
            if (it.containsKey(CommonConstants.KEY_REDIRECTION_URL)) {
                binding.webUrl = it.getString(CommonConstants.KEY_REDIRECTION_URL)
            }
        }
    }
}