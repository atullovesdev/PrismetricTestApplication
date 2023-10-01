package com.e.prismetrictestapplication.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.e.prismetrictestapplication.AdapterList.DealsHorizontalAdapter
import com.e.prismetrictestapplication.AdapterList.GridCustomAdapter
import com.e.prismetrictestapplication.AdapterList.TopHorizontalAdapter
import com.e.prismetrictestapplication.ListModel.DealsHorizintalModel
import com.e.prismetrictestapplication.ListModel.TopHorizintalModel
import com.e.prismetrictestapplication.R
import java.util.Arrays

class HomeFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var item: MutableList<TopHorizintalModel>? = null
    private var adapter: TopHorizontalAdapter? = null

    //for deals
    private var deals_recyclerView: RecyclerView? = null
    private var deals_item: MutableList<DealsHorizintalModel>? = null
    private var deals_adapter: DealsHorizontalAdapter? = null

    // ArrayList for person names
    var personNames: ArrayList<*> = ArrayList(
        Arrays.asList(
            "Shirts",
            "Jeans",
            "T-shirts",
            "Person 4",
            "Person 5",
            "Person 6",
            "Person 7",
            "Person 8",
            "Person 9",
            "Person 10",
            "Person 11",
            "Person 12",
            "Person 13",
            "Person 14"
        )
    )
    var personPrices: ArrayList<*> = ArrayList(
        Arrays.asList(
            "$15.00",
            "$5.00",
            "$15.00",
            "$5.00",
            "$15.00",
            "$15.00",
            "Person 7",
            "Person 8",
            "Person 9",
            "Person 10",
            "Person 11",
            "Person 12",
            "Person 13",
            "Person 14"
        )
    )
    var personImages: ArrayList<*> = ArrayList(
        Arrays.asList(
            R.drawable.shirts_images,
            R.drawable.jeans,
            R.drawable.loungewear,
            R.drawable.tshirts,
            R.drawable.images2,
            R.drawable.images3,
            R.drawable.shirts_images,
            R.drawable.shirts_images,
            R.drawable.shirts_images,
            R.drawable.shirts_images,
            R.drawable.shirts_images,
            R.drawable.shirts_images,
            R.drawable.shirts_images,
            R.drawable.shirts_images
        )
    )

    // for pager/slider
    var viewPager: ViewPager? = null
    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0
    private lateinit var dots: Array<ImageView?>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //for top recycler
        recyclerView = view.findViewById(R.id.toprecycle)
        item = ArrayList()
        StaticDataList()

        //for deals recycler
        deals_recyclerView = view.findViewById(R.id.deals_recycler)
        deals_item = ArrayList()
        DealsDataList()


//for pager
        viewPager = view.findViewById<View>(R.id.pager) as ViewPager
        sliderDotspanel = view.findViewById<View>(R.id.SliderDots) as LinearLayout
        val adapters = ImageAdapter(context)
        viewPager!!.adapter = adapters
        dotscount = adapters.count
        dots = arrayOfNulls(dotscount)
        for (i in 0 until dotscount) {
            dots[i] = ImageView(context)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.non_active_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.active_dot))
        viewPager!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]!!.setImageDrawable(
                        ContextCompat.getDrawable(
                            context!!,
                            R.drawable.non_active_dot
                        )
                    )
                }
                dots[position]!!.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.active_dot
                    )
                )
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        // viewPager.setCurrentItem(adapters.getCount()-1);


        // get the reference of RecyclerView for grid
        val recyclerView = view.findViewById<View>(R.id.grid_recycler) as RecyclerView
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        val gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = gridLayoutManager // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        val customAdapter = GridCustomAdapter(requireContext(), personNames, personImages, personPrices)
        recyclerView.adapter = customAdapter // set the Adapter to RecyclerView
        return view
    }

    private fun recycleMethod() {
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true))
        val llm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView!!.layoutManager = llm
    }

    private fun StaticDataList() {
        adapter = TopHorizontalAdapter(requireContext(), item!!)
        var movie = TopHorizintalModel(R.drawable.men, "MEN")
        item!!.add(movie)
        adapter!!.notifyDataSetChanged()
        movie = TopHorizintalModel(R.drawable.women, "WOMEN")
        item!!.add(movie)
        adapter!!.notifyDataSetChanged()
        movie = TopHorizintalModel(R.drawable.kids, "KIDS")
        item!!.add(movie)
        adapter!!.notifyDataSetChanged()
        movie = TopHorizintalModel(R.drawable.beauty, "BEAUTY")
        item!!.add(movie)
        adapter!!.notifyDataSetChanged()
        movie = TopHorizintalModel(R.drawable.footwear, "FOOTWEAR")
        item!!.add(movie)
        adapter!!.notifyDataSetChanged()
        movie = TopHorizintalModel(R.drawable.categories_5, "FASHION")
        item!!.add(movie)
        adapter!!.notifyDataSetChanged()
        movie = TopHorizintalModel(R.drawable.categories_6, "DESIGNER")
        item!!.add(movie)
        adapter!!.notifyDataSetChanged()
        adapter = TopHorizontalAdapter(requireContext(), item!!)
        recyclerView!!.setHasFixedSize(true)
        recycleMethod()
        recyclerView!!.adapter = adapter
    }

    private fun DealsDataList() {
        deals_adapter = DealsHorizontalAdapter(requireContext(), deals_item!!)
        var movie = DealsHorizintalModel(R.drawable.images1, "10% Off on all", "Designer look")
        deals_item!!.add(movie)
        deals_adapter!!.notifyDataSetChanged()
        movie = DealsHorizintalModel(R.drawable.images2, "Extra 5% off", "on order of $1500")
        deals_item!!.add(movie)
        deals_adapter!!.notifyDataSetChanged()
        movie = DealsHorizintalModel(R.drawable.images3, "Extra 5% off", "on order of $1500")
        deals_item!!.add(movie)
        deals_adapter!!.notifyDataSetChanged()
        movie = DealsHorizintalModel(R.drawable.images1, "Extra 5% off", "on order of $1500")
        deals_item!!.add(movie)
        deals_adapter!!.notifyDataSetChanged()
        movie = DealsHorizintalModel(R.drawable.images2, "Extra 5% off", "on order of $1500")
        deals_item!!.add(movie)
        deals_adapter!!.notifyDataSetChanged()
        movie = DealsHorizintalModel(R.drawable.images3, "Extra 5% off", "on order of $1500")
        deals_item!!.add(movie)
        deals_adapter!!.notifyDataSetChanged()
        movie = DealsHorizintalModel(R.drawable.images1, "Extra 5% off", "on order of $1500")
        deals_item!!.add(movie)
        deals_adapter!!.notifyDataSetChanged()
        deals_adapter = DealsHorizontalAdapter(requireContext(), deals_item!!)
        deals_recyclerView!!.setHasFixedSize(true)
        val llm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        deals_recyclerView!!.layoutManager = llm
        deals_recyclerView!!.adapter = deals_adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    inner class ImageAdapter internal constructor(var context: Context?) : PagerAdapter() {
        private val GalImages = intArrayOf(
            R.drawable.silder,
            R.drawable.silder
        )

        override fun getCount(): Int {
            return GalImages.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object` as ImageView
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val imageView = ImageView(context)
            val padding = context!!.resources.getDimensionPixelSize(R.dimen._1sdp)
            imageView.setPadding(padding, padding, padding, padding)
            imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            imageView.setImageResource(GalImages[position])
            (container as ViewPager).addView(imageView, 0)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            (container as ViewPager).removeView(`object` as ImageView)
        }
    }
}