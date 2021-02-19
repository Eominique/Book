package com.example.book.userQuotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.book.R
import com.example.book.databinding.FragmentUserQuotesBinding

class UserQuotesRecyclerViewAdapter(private val userQuotesMap: HashMap<String, UserQuotesItem>) :
    RecyclerView.Adapter<UserQuotesRecyclerViewAdapter.ViewHolder>() {


    override fun getItemCount() = userQuotesMap.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = userQuotesMap.toList()
        val second = data[position].second

        holder.binding.bookTitle.text = second.bookTitle
        holder.binding.quoteContent.text = second.content
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_user_quotes, parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val b = FragmentUserQuotesBinding.inflate(layoutInflater)
        return ViewHolder(view, b)
    }


    inner class ViewHolder(val mView: View, var binding: FragmentUserQuotesBinding) :
        RecyclerView.ViewHolder(mView)

}
