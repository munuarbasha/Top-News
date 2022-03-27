package com.news.topnews.newsdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.common.constants.CommonConstants
import com.news.topnews.databinding.FragmentNewsDetailsWebBinding

class NewsDetailsWebFragment : BaseBindingFragment<FragmentNewsDetailsWebBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsDetailsWebBinding
        get() = FragmentNewsDetailsWebBinding::inflate

    override fun setUpView() {
        getArgumentData()
    }

    private fun getArgumentData() {
        arguments?.let {
            if (it.containsKey(CommonConstants.KEY_REDIRECTION_URL)) {
                val url = it.getString(CommonConstants.KEY_REDIRECTION_URL)
                url?.let { webUrl ->
                    loadWebView(webUrl)
                }
            }
        }
    }

    private fun loadWebView(webUrl: String) {
        binding.newsDetailsWeb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        binding.newsDetailsWeb.loadUrl(webUrl)
    }

}