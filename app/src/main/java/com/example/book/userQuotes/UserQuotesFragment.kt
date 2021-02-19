package com.example.book.userQuotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book.R
import com.example.book.databinding.LayoutUserQuotesListBinding

class UserQuotesFragment: Fragment() {

    private val userQuotesMap: HashMap<String, UserQuotesItem> = hashMapOf()
    private lateinit var binding: LayoutUserQuotesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_user_quotes_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userQuotesMap["cos"] = UserQuotesItem(2, "cccca", "ssdasd", "kfkjdsakj")
        userQuotesMap["we"] = UserQuotesItem(3, "rrrr", "qqq", "eee")
        userQuotesMap["ew"] = UserQuotesItem(1, "yyyy", "kuwwwpa", "rrrr")

        setUpRecycler()
    }


    private fun setUpRecycler() {
        binding.userQuoteItemList.layoutManager = LinearLayoutManager(context)
        binding.userQuoteItemList.adapter = UserQuotesRecyclerViewAdapter(userQuotesMap)
    }


}
