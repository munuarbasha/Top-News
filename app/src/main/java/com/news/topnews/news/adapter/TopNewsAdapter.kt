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
    private val onNewsClicked: (newsData: NewsData, itemView: View) -> Unit
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

    var list: List<NewsData>
        get() = this.newsList
        set(list) {
            this.newsList.clear()
            this.newsList.addAll(list)
            notifyDataSetChanged()
        }

    fun addList(list: List<NewsData>) {
        val oldSize: Int = this.newsList.size
        this.newsList.addAll(list)
        notifyItemRangeChanged(oldSize, this.newsList.size)
    }

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