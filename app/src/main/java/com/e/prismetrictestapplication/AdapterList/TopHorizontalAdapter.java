package com.e.prismetrictestapplication.AdapterList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.prismetrictestapplication.ListModel.TopHorizintalModel;
import com.e.prismetrictestapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TopHorizontalAdapter extends RecyclerView.Adapter<TopHorizontalAdapter.ViewHolderClass> {
    private Context context;
    private List<TopHorizintalModel> modelitem;

  public TopHorizontalAdapter(Context context,List<TopHorizintalModel> modelitem){
      this.context=context;
      this.modelitem=modelitem;
  }


    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.topmodelitem,parent,false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderClass holder, int position) {
      TopHorizintalModel model=modelitem.get(position);
      holder.topimg.setImageResource(model.getImg());
      holder.img_title.setText(model.getImg_title());
    }

    @Override
    public int getItemCount() {
        return modelitem.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
     private ImageView topimg;
     private TextView img_title;
        public ViewHolderClass(@NonNull @NotNull View itemView) {
            super(itemView);

            topimg=itemView.findViewById(R.id.topimage);
            img_title=itemView.findViewById(R.id.img_title);

        }
    }
}
