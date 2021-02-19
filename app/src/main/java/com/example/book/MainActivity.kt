package com.example.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.book.bookQuotes.BookQuotesFragment
import com.example.book.books.BooksFragmentList
import com.example.book.databinding.ActivityMainBinding
import com.example.book.menu.MenuFragment
import com.example.book.news.NewsFragment
import com.example.book.userQuotes.UserQuotesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

 private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setViewPager()
   }

    private fun setViewPager() {
        binding.viewPager.adapter = getFragmentPagerAdapter()
        binding.navigationB.setOnNavigationItemSelectedListener(
            getBottomNavigationItemSelectorListener()        )
  //?
 //     binding.viewPager.addOnPageChangeListener(getOnPageChangeListener())
       binding.viewPager.offscreenPageLimit = 5
    }



    private fun getBottomNavigationItemSelectorListener() =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_books -> {
                   binding.viewPager.currentItem = 0
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_user_quotes -> {
                    binding.viewPager.currentItem = 1
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_books_quotes -> {
                    binding.viewPager.currentItem = 2
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_news -> {
                    binding.viewPager.currentItem = 3
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_menu -> {
                    binding.viewPager.currentItem = 4
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        }


    private fun getFragmentPagerAdapter() =
        //? lifecycle
        object : FragmentStateAdapter(supportFragmentManager, lifecycle) {
            override fun getItemCount() = 5

            override fun createFragment(position: Int) = when (position) {
                USER_QUOTES -> UserQuotesFragment()
                USER_BOOKS -> BooksFragmentList()
                BOOK_QUOTES -> BookQuotesFragment()
                NEWS -> NewsFragment()
                MENU -> MenuFragment()

                else -> {
                    Log.wtf("mistake ......", " .....")
                    Fragment()
                }
            }


        }

    private fun getOnPageChangeListener() =
        object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int) { }
            override fun onPageSelected(position: Int) {
                binding.navigationB.menu.getItem(position).isChecked = true
            }
            override fun onPageScrollStateChanged(state: Int) { }

        }

    companion object {
        const val USER_BOOKS = 0
        const val USER_QUOTES = 1
        const val BOOK_QUOTES = 2
        const val NEWS = 3
        const val MENU = 4

    }
}