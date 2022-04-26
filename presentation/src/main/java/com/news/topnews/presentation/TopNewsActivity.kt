package com.news.topnews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.news.topnews.presentation.databinding.ActivityTopNewsBinding
import dagger.hilt.android.AndroidEntryPoint
/**
 * Main Activity holds FragmentContainerView
 */
@AndroidEntryPoint
class TopNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}