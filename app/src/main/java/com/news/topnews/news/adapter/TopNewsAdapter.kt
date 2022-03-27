package com.news.topnews.news.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.topnews.databinding.TopNewsListItemBinding
import com.news.topnews.domain.entity.NewsData

@SuppressLint("NotifyDataSetChanged")
class TopNewsAdapter(
    private val newsList: List<NewsData>,
    private val onNewsClicked: (newsData: NewsData, itemView: View) -> Unit
) : RecyclerView.Adapter<TopNewsAdapter.TopNewsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopNewsViewHolder {
        return TopNewsViewHolder(
            TopNewsListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        holder.bindTopNews(newsList[position])
    }

    override fun getItemCount() = newsList.size

    inner class TopNewsViewHolder(private val binding: TopNewsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTopNews(item: NewsData) {
            binding.newsData = item
            binding.root.setOnClickListener {
                onNewsClicked.invoke(item, itemView)
            }
        }
    }

}