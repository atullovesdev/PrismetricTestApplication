package com.e.prismetrictestapplication.AdapterList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.prismetrictestapplication.ListModel.ModelList
import com.e.prismetrictestapplication.MapsActivity
import com.e.prismetrictestapplication.R

class AdapterClass(private val context: Context, private val main_list: List<ModelList>) :
    RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.details_list, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val modelList = main_list[position]
        holder.name.text = modelList.name
        holder.email.text = modelList.email
        holder.address.text = modelList.address!!.city
        holder.com_name.text = modelList.company!!.name
        holder.website.text = modelList.website
        holder.phone.text = modelList.phone
        holder.main_layout.setOnClickListener {
            val lat = main_list[position].address!!.geo!!.lat
            val lng = main_list[position].address!!.geo!!.lng
            val i = Intent(context, MapsActivity::class.java)
            i.putExtra("getlat", lat)
            i.putExtra("getlng", lng)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return main_list.size
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val email: TextView
        val address: TextView
        private val com_details: TextView
        val com_name: TextView
        val website: TextView
        val phone: TextView
        val main_layout: LinearLayout

        init {
            main_layout = itemView.findViewById(R.id.main_layout)
            name = itemView.findViewById(R.id.name)
            email = itemView.findViewById(R.id.email)
            address = itemView.findViewById(R.id.address)
            com_details = itemView.findViewById(R.id.com_details)
            com_name = itemView.findViewById(R.id.com_name)
            website = itemView.findViewById(R.id.website)
            phone = itemView.findViewById(R.id.phone)
        }
    }
}