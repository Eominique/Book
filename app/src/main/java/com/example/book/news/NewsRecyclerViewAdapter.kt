package com.example.book.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.book.R
import com.example.book.databinding.FragmentNewsBinding

class NewsRecyclerViewAdapter(private val newsMap: HashMap<String, NewsItem>) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_news, parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val b = FragmentNewsBinding.inflate(layoutInflater)

        return ViewHolder(view, b)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
  val data = newsMap.toList()
  val second = data[position].second

   holder.binding.login.text= second.login
   holder.binding.newsTitle.text= second.title
   holder.binding.newsContent.text = second.content

Glide.with(holder.mView.context)
    .load(second.picture)
    .into(holder.binding.imgvw)
    }

    override fun getItemCount() = newsMap.size

    class ViewHolder(val mView: View,var binding: FragmentNewsBinding) : RecyclerView.ViewHolder(mView)

}