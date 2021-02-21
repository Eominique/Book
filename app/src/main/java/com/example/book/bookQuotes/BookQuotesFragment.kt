package com.example.book.bookQuotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book.R
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.book.database.Api
import com.example.book.databinding.LayoutBookQuoteListBinding
import com.example.book.utils.LineItemDecoration
import org.json.JSONException
import org.json.JSONObject


class BookQuotesFragment : Fragment() {

    private lateinit var bookQuotesMap: MutableList<BookQuotesItem>
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

        bookQuotesMap = mutableListOf()
        loadBooks()
        setUpRecycler()
    }


    private fun setUpRecycler() {
        binding.bookQuoteItemList.layoutManager = LinearLayoutManager(context)
        binding.bookQuoteItemList.addItemDecoration(
            LineItemDecoration(
                this.context,
                LinearLayout.VERTICAL
            )
        )
        binding.bookQuoteItemList.adapter = BookQuotesRecyclerViewAdapter(bookQuotesMap)
    }


    private fun loadBooks() {
val stringRequest = StringRequest(Request.Method.GET,
Api.URL_GET_BOOK_QUOTES,
Response.Listener<String> { s->
    try {
        val obj = JSONObject(s)
        if(!obj.getBoolean("error")){
   val array = obj.getJSONArray("quotes")

   for(i in 0..array.length() -1){
       val objectQuote = array.getJSONObject(i)
       val bookQuote = BookQuotesItem(
           objectQuote.getInt("id"),
           objectQuote.getString("bookTitle"),
           objectQuote.getString("content"),
           objectQuote.getString("userName")
                  )
       bookQuotesMap.add(bookQuote)
   }
  binding.bookQuoteItemList.adapter?.notifyDataSetChanged()
        } else{
            Toast.makeText(this.context, obj.getString("message"), Toast.LENGTH_LONG).show()
        }

    }catch (e: JSONException){
        e.printStackTrace()
    }
}, Response.ErrorListener { error ->Toast.makeText(this.context, error.message, Toast.LENGTH_LONG).show() })

  val requestQueue = Volley.newRequestQueue(this.context)
requestQueue.add<String>(stringRequest)

    }




}
