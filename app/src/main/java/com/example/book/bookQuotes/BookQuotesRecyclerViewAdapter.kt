package com.example.book.bookQuotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.book.R
import com.example.book.databinding.FragmentBookQuotesBinding

class BookQuotesRecyclerViewAdapter(
    private val bookQuotesMap: HashMap<String, BookQuotesItem>
) : RecyclerView.Adapter<BookQuotesRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_book_quotes, parent, false)
        val inflater = LayoutInflater.from(parent.context)
        val b = FragmentBookQuotesBinding.inflate(inflater)
        return ViewHolder(view, b)
    }


    override fun getItemCount() = bookQuotesMap.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
val data = bookQuotesMap.toList()
val second = data[position].second

holder.binding.bookTitle.text = second.bookTitle
holder.binding.quoteContent.text = second.content
        holder.binding.userName.text = second.userName

    }


    inner class ViewHolder(mView: View, val binding: FragmentBookQuotesBinding) :
        RecyclerView.ViewHolder(mView)

}
