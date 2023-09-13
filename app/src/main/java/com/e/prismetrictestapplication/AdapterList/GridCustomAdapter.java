package com.e.prismetrictestapplication.AdapterList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.prismetrictestapplication.MainActivity;
import com.e.prismetrictestapplication.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GridCustomAdapter extends RecyclerView.Adapter<GridCustomAdapter.ViewHolder> {
    ArrayList personNames;
    ArrayList personImages;
    ArrayList personPrices;
    Context context;
    public GridCustomAdapter(Context context, ArrayList personNames, ArrayList personImages, ArrayList personPrices) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
        this.personPrices=personPrices;
    }
    @Override
    public GridCustomAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GridCustomAdapter.ViewHolder holder, int position) {
        // set the data in items
        holder.name.setText(personNames.get(position).toString());
        holder.image.setImageResource((Integer) personImages.get(position));

//        Picasso.with(context)
//                .load(String.valueOf(personImages.get(position)))
//                .into(holder.image);


        holder.price.setText(personPrices.get(position).toString());
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, MainActivity.class);
              //  intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name,price;
        ImageView image;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            price=itemView.findViewById(R.id.price);
        }
    }
}
