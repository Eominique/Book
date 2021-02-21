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
import com.example.book.utils.ItemAnimation
import com.example.book.utils.Tools
import com.example.book.utils.ViewAnimation

class BookQuotesRecyclerViewAdapter(
    private val bookQuotesMap: MutableList<BookQuotesItem>
) : RecyclerView.Adapter<BookQuotesRecyclerViewAdapter.ViewHolder>() {

    private val animation_type = ItemAnimation.FADE_IN

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
        val second = data[position]

        holder.binding.bookTitle.text = second.bookTitle
        holder.binding.quoteContent.text = second.content
        holder.binding.userName.text = second.userName

        holder.binding.btExpand.setOnClickListener {
            val show = togglelayoutExpand(!second.expanded, it, holder.binding.lytExpand)
            second.expanded = show
        }

        if (second.expanded) {
            holder.binding.lytExpand.visibility = View.VISIBLE
        } else {
            holder.binding.lytExpand.visibility = View.GONE
        }
        Tools.toggleArrow(second.expanded, holder.binding.btExpand, false)
        setAnimation(holder.itemView, position)
    }

    private var lastPosition = -1
    private var on_attach = true

    private fun setAnimation(view: View, position: Int) {
        if (position > lastPosition) {
            ItemAnimation.animate(view, if (on_attach) position else -1, animation_type)
            lastPosition = position
        }
    }

    private fun togglelayoutExpand(show: Boolean, view: View, lytExpand: LinearLayout): Boolean {
        Tools.toggleArrow(show, view)
        if (show) {
      //      ViewAnimation.expand(lyt_expand)
        } else {
      //      ViewAnimation.collapse(lyt_expand)
        }
        return show
    }


    inner class ViewHolder(mView: View, val binding: FragmentBookQuotesBinding) :
        RecyclerView.ViewHolder(mView)

}
