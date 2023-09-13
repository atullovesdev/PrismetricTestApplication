package com.e.prismetrictestapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.prismetrictestapplication.R;


public class MyOrderFragment extends Fragment {
    View fragmentView;
    public MyOrderFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_search, container, false);
        return fragmentView;
       // return inflater.inflate(R.layout.fragment_my_order, container, false);
    }
}