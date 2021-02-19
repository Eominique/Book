package com.example.book.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.book.R

class BooksFragmentList : Fragment(R.layout.layout_book_list) {

private val booksMap: HashMap<String, BookItem> = hashMapOf()
//private lateinit var binding: FragmentBookListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_book_list, container, false)

//  binding = Book
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        booksMap["cos"] = BookItem(
            6,
            "Dawca",
            "2013",
            "Dawca",
            "http://localhost/BookstoreApi/books/book5.pdf",
            "http://192.168.0.164/BookstoreApi/images/image3.jpg",
            "Trzymający w napięciu thriller medyczny",
            "4"
        )
        booksMap["za"] = BookItem(
            7,
            "Dom na Wyrębach",
            "2014",
            "Nietoperz człowiek",
            "http://localhost/BookstoreApi/books/book7.pdf",
            "http://192.168.0.164/BookstoreApi/images/image6.jpg",
            "Trzymający w napięciu horror",
            "3"
        )
        booksMap["ssa"] = BookItem(
            8,
            "Biorca",
            "2018",
            "Albatros",
            "http://localhost/BookstoreApi/books/book8.pdf",
            "http://192.168.0.164/BookstoreApi/images/image9.jpg",
            "Trzymający w napięciu thriller medyczny ale nie",
            "1"
        )
        booksMap["sss"] = BookItem(
            9,
            "Wyrąb na domach",
            "2018",
            "Albatros",
            "http://localhost/BookstoreApi/books/book8.pdf",
            "http://192.168.0.164/BookstoreApi/images/image4.jpg",
            "Trzymający w napięciu horror ale nie",
            "1"
        )
        setUpRecycler()
    }

    private fun setUpRecycler() {

    }


}
