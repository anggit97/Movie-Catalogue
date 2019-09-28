package com.anggit97.moviecatalogue.feature.popular


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.anggit97.moviecatalogue.R
import com.anggit97.moviecatalogue.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 */
class PopularMovieFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_movie, container, false)
    }
}
