package com.e.prismetrictestapplication.AdapterList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.prismetrictestapplication.ListModel.TopHorizintalModel
import com.e.prismetrictestapplication.R

class TopHorizontalAdapter(
    private val context: Context,
    private val modelitem: List<TopHorizintalModel>
) : RecyclerView.Adapter<TopHorizontalAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = LayoutInflater.from(context.applicationContext)
            .inflate(R.layout.topmodelitem, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val model = modelitem[position]
        holder.topimg.setImageResource(model.img)
        holder.img_title.text = model.img_title
    }

    override fun getItemCount(): Int {
        return modelitem.size
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topimg: ImageView
        val img_title: TextView

        init {
            topimg = itemView.findViewById(R.id.topimage)
            img_title = itemView.findViewById(R.id.img_title)
        }
    }
}