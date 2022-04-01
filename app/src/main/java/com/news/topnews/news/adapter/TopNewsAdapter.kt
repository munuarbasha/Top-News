package com.news.topnews.news.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.topnews.databinding.TopNewsListItemBinding
import com.news.topnews.domain.model.NewsData

/**
 * Adapter class for Top News list Recyclerview
 */
@SuppressLint("NotifyDataSetChanged")
class TopNewsAdapter(
    private val onNewsItemClicked: (newsData: NewsData, itemView: View) -> Unit
) : RecyclerView.Adapter<TopNewsAdapter.TopNewsViewHolder>() {
    private var newsList: ArrayList<NewsData> = ArrayList()

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

    var newsStoryList: List<NewsData>
        get() = this.newsList
        set(list) {
            this.newsList.clear()
            this.newsList.addAll(list)
            notifyDataSetChanged()
        }

    fun addList(list: List<NewsData>) {
        val oldSize: Int = this.newsList.size
        this.newsList.addAll(list)
        notifyItemRangeChanged(oldSize-1, this.newsList.size)
    }

    inner class TopNewsViewHolder(private val binding: TopNewsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTopNews(item: NewsData) {
            binding.newsData = item
            binding.root.setOnClickListener {
                onNewsItemClicked.invoke(item, it)
            }
        }
    }

}