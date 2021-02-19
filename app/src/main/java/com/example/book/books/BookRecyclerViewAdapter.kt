package com.example.book.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.book.R
import com.example.book.databinding.FragmentBooksBinding

class BookRecyclerViewAdapter(private val bookMap: HashMap<String, BookItem>)
    :RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
 val view = LayoutInflater.from(parent.context)
     .inflate(R.layout.fragment_books, parent, false)
  val inflater = LayoutInflater.from(parent.context)
    val b = FragmentBooksBinding
        .inflate(inflater,parent,false )

 return ViewHolder(view,b )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val data = bookMap.toList()
        val second = data[position].second
        holder.binding.bookTitle.text = second.title
        holder.binding.bookDescription.text = second.description
        holder.binding.imgvw.setImageResource(second.picture as Int)
        Glide.with(holder.mView.context)
            .load(second.picture)
            .into(holder.binding.imgvw)

    }

    override fun getItemCount() = bookMap.size


class ViewHolder(val mView: View, var binding: FragmentBooksBinding)
    : RecyclerView.ViewHolder(mView)





}