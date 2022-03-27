package com.news.topnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.news.topnews.databinding.ActivityTopNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}