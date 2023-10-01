package com.e.prismetrictestapplication.AdapterList

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MenuAdapter(options: ArrayList<String>) : BaseAdapter() {
    private var mOptions = ArrayList<String>()
    private val mOptionViews = ArrayList<MyDuoOptionView>()

    init {
        mOptions = options
    }

    override fun getCount(): Int {
        return mOptions.size
    }

    override fun getItem(position: Int): Any {
        return mOptions[position]
    }

    fun setViewSelected(position: Int, selected: Boolean) {

        // Looping through the options in the menu
        // Selecting the chosen option
        for (i in mOptionViews.indices) {
            if (i == position) {
                mOptionViews[i].isSelected = selected
            } else {
                mOptionViews[i].isSelected = !selected
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val option = mOptions[position]

        // Using the MyDuoOptionView to easily recreate the demo
        val optionView: MyDuoOptionView
        optionView = convertView as MyDuoOptionView

        // Using the MyDuoOptionView's default selectors
        optionView.bind(option, null, null)

        // Adding the views to an array list to handle view selection
        mOptionViews.add(optionView)
        return optionView
    }
}