package com.example.book.bookQuotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book.R
import com.example.book.databinding.FragmentBookQuotesBinding
import com.example.book.databinding.LayoutBookQuoteListBinding


class BookQuotesFragment : Fragment(R.layout.layout_book_quote_list) {

private val bookQuotesMap = hashMapOf<String, BookQuotesItem>()
private lateinit var binding: LayoutBookQuoteListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_book_quote_list, container, false)
       }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    bookQuotesMap["ooo1"]= BookQuotesItem(1, "tyytil1","cong1", "sdfsdf1")
    bookQuotesMap["ooo2"]= BookQuotesItem(2, "tyytil2","cong2", "sdfsdf2")
    bookQuotesMap["ooo3"]= BookQuotesItem(3, "tyytil3","cong3", "sdfsdf3")
    bookQuotesMap["ooo4"]= BookQuotesItem(4, "tyytil4","cong4", "sdfsdf4")
    bookQuotesMap["ooo5"]= BookQuotesItem(5, "tyytil5","cong5", "sdfsdf5")

    setUpRecycler()
    }

    private fun setUpRecycler() {
binding.bookQuoteItemList.layoutManager = LinearLayoutManager(context)
binding.bookQuoteItemList.adapter = BookQuotesRecyclerViewAdapter(bookQuotesMap)
    }


interface OnBookQuotesInteractionListener{
//    fun onUserSelected(user: UserItem, image: View)
}

}
