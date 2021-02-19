package com.example.book.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book.R
import com.example.book.databinding.FragmentMenuBinding
import com.example.book.databinding.FragmentNewsBinding
import com.example.book.databinding.LayoutNewsListBinding

class NewsFragment : Fragment() {

private val newsMap = hashMapOf<String, NewsItem>()
private lateinit var binding: LayoutNewsListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.layout_news_list, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsMap["cos"] = NewsItem(2, "content", "ffffff", "login", "http://192.168.0.164/BookstoreApi/images/image3.jpg")
        newsMap["we"] = NewsItem(3, "rrrr", "qqq", "eee", "http://192.168.0.164/BookstoreApi/images/image6.jpg")
        newsMap["ew"] = NewsItem(4, "yyyy", "kuwwwpa", "rrrr", "http://192.168.0.164/BookstoreApi/images/image9.jpg")

        setUpRecycler()
    }

    private fun setUpRecycler() {
binding.newsItemList.layoutManager = LinearLayoutManager(context)
binding.newsItemList.adapter = NewsRecyclerViewAdapter(newsMap)
    }


  interface onNewsInteractionListener{
     // fun  onUserSelected(user: UserItem, image: View)
  }

}
