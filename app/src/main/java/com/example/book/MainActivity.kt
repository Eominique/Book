package com.example.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.book.userQuotes.UserQuotesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    setViewPager()
    }

    private fun setViewPager() {
        viewPager.adapter = getFragmentPagerAdapter()

    }

    private fun getFragmentPagerAdapter() =
  //? lifecycle
    object: FragmentStateAdapter(supportFragmentManager, lifecycle){
        override fun getItemCount()=5

        override fun createFragment(position: Int) = when(position){
            USER_QUOTES -> UserQuotesFragment()
            USER_BOOKS -> BooksFragment()
            BOOK_QUOTES -> BookQuotesFragment()
            NEWS -> NewsFragment()
            MENU -> MenuFragment()

            else -> {
                Fragment()
            }
        }



    }




    companion object {
        const val USER_BOOKS = 0
        const val USER_QUOTES = 1
        const val BOOK_QUOTES = 2
        const val NEWS = 3
        const val MENU = 4

    }
}