package com.news.topnews.news.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.databinding.FragmentTopNewsListBinding

class TopNewsListFragment : BaseBindingFragment<FragmentTopNewsListBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTopNewsListBinding
        get() = FragmentTopNewsListBinding::inflate

    override fun setUpViewEvents() {
        showLoading()
    }
}