package com.e.prismetrictestapplication.AdapterList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.prismetrictestapplication.ListModel.DealsHorizintalModel;
import com.e.prismetrictestapplication.ListModel.TopHorizintalModel;
import com.e.prismetrictestapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;
public class DealsHorizontalAdapter extends RecyclerView.Adapter<DealsHorizontalAdapter.ViewHolderClass> {
    private Context context;
    private List<DealsHorizintalModel> modelitem;

  public DealsHorizontalAdapter(Context context, List<DealsHorizintalModel> modelitem){
      this.context=context;
      this.modelitem=modelitem;
  }


    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.deals_item_layout,parent,false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderClass holder, int position) {
      DealsHorizintalModel model=modelitem.get(position);
      holder.deals_img.setImageResource(model.getImg_deals());
      holder.deals_title.setText(model.getDealsimg_title());
      holder.deals_samall_title.setText(model.getDealsimg_smalltitle());
    }

    @Override
    public int getItemCount() {
        return modelitem.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
     private ImageView deals_img;
     private TextView deals_title,deals_samall_title;
        public ViewHolderClass(@NonNull @NotNull View itemView) {
            super(itemView);

            deals_img=itemView.findViewById(R.id.deals_img);
            deals_title=itemView.findViewById(R.id.deals_text);
            deals_samall_title=itemView.findViewById(R.id.deals_small_text);

        }
    }
}
