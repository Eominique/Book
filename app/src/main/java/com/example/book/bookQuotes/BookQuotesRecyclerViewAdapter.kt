package com.example.book.bookQuotes

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.book.R

class BookQuotesRecyclerViewAdapter(
    private var bookQuotesMap: MutableList<BookQuotesItem>,
    private val context: Context
) : RecyclerView.Adapter<BookQuotesRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }


    override fun getItemCount() = bookQuotesMap.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val lytExpand = mView.findViewById(R.id.lyt_expand) as View
        val expand = mView.findViewById(R.id.bt_expand) as ImageButton

        val bookTitle = mView.findViewById<TextView>(R.id.bookTitle)!!
        val quoteContent = mView.findViewById<TextView>(R.id.quoteContent)!!
        val listener: LinearLayout = mView.findViewById(R.id.book_quotes_listener)
    }




}
