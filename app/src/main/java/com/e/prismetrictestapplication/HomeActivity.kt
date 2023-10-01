package com.e.prismetrictestapplication


import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.e.prismetrictestapplication.AdapterList.MenuAdapter
import com.e.prismetrictestapplication.fragments.HomeFragment
import com.e.prismetrictestapplication.fragments.MyOrderFragment
import com.e.prismetrictestapplication.fragments.NotificationFragment
import com.e.prismetrictestapplication.fragments.ProfileFragment
import com.e.prismetrictestapplication.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView.OnMenuClickListener
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle
import java.util.Arrays

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    OnMenuClickListener {
    var bottomNavigationView: BottomNavigationView? = null

    //  private DrawerLayout drawer;
    private var mMenuAdapter: MenuAdapter? = null
    private var mViewHolder: ViewHolder? = null
    private var mTitles = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mTitles = ArrayList(Arrays.asList(*resources.getStringArray(R.array.menuOptions)))

        // Initialize the views
        mViewHolder = ViewHolder()

        // Handle toolbar actions
        //   handleToolbar();

        // Handle menu actions
        handleMenu()

        // Handle drawer actions
        handleDrawer()

        // Show main fragment in container
        goToFragment(HomeFragment(), false)
        mMenuAdapter!!.setViewSelected(0, true)
        title = mTitles[0]


//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        drawer = findViewById(R.id.drawer_layout);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
       bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView?.setOnNavigationItemSelectedListener(this)
        bottomNavigationView?.setSelectedItemId(R.id.fragment_home)
        bottomNavigationView?.setItemIconTintList(null)
    }

    // private void handleToolbar() {
    //     setSupportActionBar(mViewHolder.mToolbar);
    // }
    private fun handleDrawer() {
        val duoDrawerToggle = DuoDrawerToggle(
            this,
            mViewHolder!!.mDuoDrawerLayout,
            mViewHolder!!.mToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        mViewHolder!!.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle)
        duoDrawerToggle.syncState()
    }

    private fun handleMenu() {
        mMenuAdapter = MenuAdapter(mTitles)
        mViewHolder!!.mDuoMenuView.setOnMenuClickListener(this)

       try {
           mViewHolder!!.mDuoMenuView.adapter = mMenuAdapter}
       catch(e : Exception){
           e.stackTrace
       }
    }

    //    @Override
    //    public void onBackPressed() {
    //        if (drawer.isDrawerOpen(GravityCompat.START)){
    //            drawer.closeDrawer(GravityCompat.START);
    //        }else {
    //            super.onBackPressed();
    //        }
    //    }
    var homeFragment = HomeFragment()
    var searchFragment = SearchFragment()
    var myOrderFragment = MyOrderFragment()
    var notificationFragment = NotificationFragment()
    var profileFragment = ProfileFragment()
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fragment_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame, homeFragment).commit()
                return true
            }

            R.id.fragment_search -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame, searchFragment)
                    .commit()
                return true
            }

            R.id.fragment_my_order -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame, myOrderFragment)
                    .commit()
                return true
            }

            R.id.fragment_notification -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame, notificationFragment)
                    .commit()
                return true
            }

            R.id.fragment_profile -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame, profileFragment)
                    .commit()
                return true
            }
        }
        return true
    }

    override fun onFooterClicked() {
        Toast.makeText(this, "onFooterClicked", Toast.LENGTH_SHORT).show()
    }

    override fun onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show()
    }

    private fun goToFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.add(R.id.container, fragment).commit()
    }

    override fun onOptionClicked(position: Int, objectClicked: Any) {
        // Set the toolbar title
        title = mTitles[position]

        // Set the right options selected
        mMenuAdapter!!.setViewSelected(position, true)
        when (position) {
            else -> goToFragment(HomeFragment(), false)
        }

        // Close the drawer
        mViewHolder!!.mDuoDrawerLayout.closeDrawer()
    }

    private inner class ViewHolder internal constructor() {
        val mDuoDrawerLayout: DuoDrawerLayout
        val mDuoMenuView: DuoMenuView
        val mToolbar: Toolbar

        init {
            mDuoDrawerLayout = findViewById<View>(R.id.drawer) as DuoDrawerLayout
            mDuoMenuView = mDuoDrawerLayout.menuView as DuoMenuView
            mToolbar = findViewById<View>(R.id.toolbar) as Toolbar
        }
    }
}