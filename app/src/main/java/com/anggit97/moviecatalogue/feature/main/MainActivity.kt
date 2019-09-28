package com.anggit97.moviecatalogue.feature.main

import android.os.Bundle
import com.anggit97.moviecatalogue.R
import com.anggit97.moviecatalogue.base.BaseActivity
import com.anggit97.moviecatalogue.feature.popular.PopularMovieFragment
import com.anggit97.moviecatalogue.feature.toprated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var mainTabAdapter: MainTabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMainTabAdapter()
    }

    private fun initMainTabAdapter() {
        mainTabAdapter = MainTabAdapter(supportFragmentManager).apply {
            addFragment(PopularMovieFragment(), getString(R.string.popular))
            addFragment(TopRatedFragment(), getString(R.string.top_rated))
        }
        viewPager.adapter = mainTabAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
