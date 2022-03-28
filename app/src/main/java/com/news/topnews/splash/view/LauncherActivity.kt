package com.news.topnews.splash.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.news.topnews.R
import com.news.topnews.TopNewsActivity
import com.news.topnews.common.extensions.show
import com.news.topnews.common.utils.AlertDialogUtils
import com.news.topnews.common.utils.DeviceRootChecker
import com.news.topnews.databinding.ActivitySplashScreenBinding
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.splash.viewmodel.SplashScreenViewModel

class LauncherActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    private val viewModel by viewModels<SplashScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (DeviceRootChecker.isRooted(this)) {
            AlertDialogUtils.showError(this, getString(R.string.device_rooted_message)) {
                finish()
            }
        } else {
            initObserver()
        }
    }

    private fun initObserver() {
        viewModel.splashStatus.observe(this) {
            when (it) {
                is ResponseWrapper.Loading -> binding.loadingProgressBar.show()
                else -> {
                    startActivity(Intent(this, TopNewsActivity::class.java))
                    this.finish()
                }
            }
        }
    }
}