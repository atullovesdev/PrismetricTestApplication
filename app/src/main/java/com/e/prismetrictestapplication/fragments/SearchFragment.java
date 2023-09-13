package com.e.prismetrictestapplication.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.prismetrictestapplication.R;


public class SearchFragment extends Fragment {
    View fragmentView;
    public SearchFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_search, container, false);
       // return inflater.inflate(R.layout.fragment_search, container, false);
        return fragmentView;
    }
}