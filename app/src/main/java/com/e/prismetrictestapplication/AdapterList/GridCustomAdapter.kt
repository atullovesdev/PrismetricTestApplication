package com.e.prismetrictestapplication.AdapterList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.prismetrictestapplication.MainActivity
import com.e.prismetrictestapplication.R

class GridCustomAdapter(
    var context: Context,
    var personNames: ArrayList<*>,
    var personImages: ArrayList<*>,
    var personPrices: ArrayList<*>
) : RecyclerView.Adapter<GridCustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // infalte the item Layout
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_row_layout, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // set the data in items
        holder.name.text = personNames[position].toString()
        holder.image.setImageResource((personImages[position] as Int))

//        Picasso.with(context)
//                .load(String.valueOf(personImages.get(position)))
//                .into(holder.image);
        holder.price.text = personPrices[position].toString()
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener {
            // open another activity on item click
            val intent = Intent(context, MainActivity::class.java)
            //  intent.putExtra("image", personImages.get(position)); // put image data in Intent
            context.startActivity(intent) // start Intent
        }
    }

    override fun getItemCount(): Int {
        return personNames.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // init the item view's
        var name: TextView
        var price: TextView
        var image: ImageView

        init {
            // get the reference of item view's
            name = itemView.findViewById<View>(R.id.name) as TextView
            image = itemView.findViewById<View>(R.id.image) as ImageView
            price = itemView.findViewById(R.id.price)
        }
    }
}