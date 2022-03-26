package com.news.topnews.splash.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.news.topnews.MainActivity
import com.news.topnews.common.extensions.show
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
        initObserver()
    }

    private fun initObserver() {
        viewModel.splashStatus.observe(this) {
            when (it) {
                is ResponseWrapper.Success -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }
                else -> {
                    binding.loadingProgressBar.show()
                }
            }
        }
    }
}