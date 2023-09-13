package com.e.prismetrictestapplication.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.e.prismetrictestapplication.AdapterList.DealsHorizontalAdapter;
import com.e.prismetrictestapplication.AdapterList.GridCustomAdapter;
import com.e.prismetrictestapplication.AdapterList.TopHorizontalAdapter;
import com.e.prismetrictestapplication.ListModel.DealsHorizintalModel;
import com.e.prismetrictestapplication.ListModel.TopHorizintalModel;
import com.e.prismetrictestapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TopHorizintalModel> item;
    private TopHorizontalAdapter adapter;
    //for deals
    private RecyclerView deals_recyclerView;
    private List<DealsHorizintalModel> deals_item;
    private DealsHorizontalAdapter deals_adapter;

    // ArrayList for person names
    ArrayList personNames = new ArrayList<>(Arrays.asList("Shirts", "Jeans", "T-shirts", "Person 4", "Person 5", "Person 6", "Person 7", "Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
    ArrayList personPrices = new ArrayList<>(Arrays.asList("$15.00", "$5.00", "$15.00", "$5.00", "$15.00", "$15.00", "Person 7", "Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
    ArrayList personImages = new ArrayList<>(Arrays.asList(R.drawable.shirts_images, R.drawable.jeans, R.drawable.loungewear, R.drawable.tshirts, R.drawable.images2, R.drawable.images3, R.drawable.shirts_images, R.drawable.shirts_images, R.drawable.shirts_images, R.drawable.shirts_images, R.drawable.shirts_images, R.drawable.shirts_images, R.drawable.shirts_images, R.drawable.shirts_images));

    // for pager/slider
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    public HomeFragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//for top recycler
        recyclerView = view.findViewById(R.id.toprecycle);
        item = new ArrayList<>();
        StaticDataList();

        //for deals recycler
        deals_recyclerView = view.findViewById(R.id.deals_recycler);
        deals_item = new ArrayList<>();
        DealsDataList();


//for pager
         viewPager = (ViewPager) view.findViewById(R.id.pager);
        sliderDotspanel = (LinearLayout) view.findViewById(R.id.SliderDots);
        ImageAdapter adapters = new ImageAdapter(getContext());
        viewPager.setAdapter(adapters);

        dotscount = adapters.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // viewPager.setCurrentItem(adapters.getCount()-1);


        // get the reference of RecyclerView for grid
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.grid_recycler);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        GridCustomAdapter customAdapter = new GridCustomAdapter(getContext(), personNames, personImages, personPrices);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


        return view;
    }


    private void recycleMethod() {
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true))
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(llm);

    }

    private void StaticDataList() {
        adapter = new TopHorizontalAdapter(getContext(), item);
        TopHorizintalModel movie = new TopHorizintalModel(R.drawable.men, "MEN");
        item.add(movie);
        adapter.notifyDataSetChanged();
        movie = new TopHorizintalModel(R.drawable.women, "WOMEN");
        item.add(movie);
        adapter.notifyDataSetChanged();

        movie = new TopHorizintalModel(R.drawable.kids, "KIDS");
        item.add(movie);
        adapter.notifyDataSetChanged();

        movie = new TopHorizintalModel(R.drawable.beauty, "BEAUTY");
        item.add(movie);
        adapter.notifyDataSetChanged();

        movie = new TopHorizintalModel(R.drawable.footwear, "FOOTWEAR");
        item.add(movie);
        adapter.notifyDataSetChanged();

        movie = new TopHorizintalModel(R.drawable.categories_5, "FASHION");
        item.add(movie);
        adapter.notifyDataSetChanged();

        movie = new TopHorizintalModel(R.drawable.categories_6, "DESIGNER");
        item.add(movie);
        adapter.notifyDataSetChanged();

        adapter = new TopHorizontalAdapter(getContext(), item);
        recyclerView.setHasFixedSize(true);
        recycleMethod();
        recyclerView.setAdapter(adapter);


    }

    private void DealsDataList() {
        deals_adapter = new DealsHorizontalAdapter(getContext(), deals_item);
        DealsHorizintalModel movie = new DealsHorizintalModel(R.drawable.images1, "10% Off on all", "Designer look");
        deals_item.add(movie);
        deals_adapter.notifyDataSetChanged();
        movie = new DealsHorizintalModel(R.drawable.images2, "Extra 5% off", "on order of $1500");
        deals_item.add(movie);
        deals_adapter.notifyDataSetChanged();

        movie = new DealsHorizintalModel(R.drawable.images3, "Extra 5% off", "on order of $1500");
        deals_item.add(movie);
        deals_adapter.notifyDataSetChanged();

        movie = new DealsHorizintalModel(R.drawable.images1, "Extra 5% off", "on order of $1500");
        deals_item.add(movie);
        deals_adapter.notifyDataSetChanged();

        movie = new DealsHorizintalModel(R.drawable.images2, "Extra 5% off", "on order of $1500");
        deals_item.add(movie);
        deals_adapter.notifyDataSetChanged();

        movie = new DealsHorizintalModel(R.drawable.images3, "Extra 5% off", "on order of $1500");
        deals_item.add(movie);
        deals_adapter.notifyDataSetChanged();

        movie = new DealsHorizintalModel(R.drawable.images1, "Extra 5% off", "on order of $1500");
        deals_item.add(movie);
        deals_adapter.notifyDataSetChanged();

        deals_adapter = new DealsHorizontalAdapter(getContext(), deals_item);
        deals_recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        deals_recyclerView.setLayoutManager(llm);
        deals_recyclerView.setAdapter(deals_adapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);


    }

    public class ImageAdapter extends PagerAdapter {
        Context context;
        private int[] GalImages = new int[]{
                R.drawable.silder,
                R.drawable.silder
        };

        ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return GalImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(context);
            int padding = context.getResources().getDimensionPixelSize(R.dimen._1sdp);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(GalImages[position]);

            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }


}
