package com.e.prismetrictestapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.e.prismetrictestapplication.R

class MyOrderFragment : Fragment() {
    private var fragmentView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_search, container, false)
        return fragmentView
        // return inflater.inflate(R.layout.fragment_my_order, container, false);
    }
}