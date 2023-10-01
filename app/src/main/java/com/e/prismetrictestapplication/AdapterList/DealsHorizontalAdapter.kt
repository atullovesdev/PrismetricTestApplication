package com.e.prismetrictestapplication.AdapterList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.prismetrictestapplication.ListModel.DealsHorizintalModel
import com.e.prismetrictestapplication.R

class DealsHorizontalAdapter(
    private val context: Context,
    private val modelitem: List<DealsHorizintalModel>
) : RecyclerView.Adapter<DealsHorizontalAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = LayoutInflater.from(context.applicationContext)
            .inflate(R.layout.deals_item_layout, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val model = modelitem[position]
        holder.deals_img.setImageResource(model.img_deals)
        holder.deals_title.text = model.dealsimg_title
        holder.deals_samall_title.text = model.dealsimg_smalltitle
    }

    override fun getItemCount(): Int {
        return modelitem.size
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deals_img: ImageView
        val deals_title: TextView
        val deals_samall_title: TextView

        init {
            deals_img = itemView.findViewById(R.id.deals_img)
            deals_title = itemView.findViewById(R.id.deals_text)
            deals_samall_title = itemView.findViewById(R.id.deals_small_text)
        }
    }
}