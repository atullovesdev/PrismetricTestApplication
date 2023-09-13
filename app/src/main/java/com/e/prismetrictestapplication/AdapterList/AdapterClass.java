package com.e.prismetrictestapplication.AdapterList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.prismetrictestapplication.ListModel.ModelList;
import com.e.prismetrictestapplication.MapsActivity;
import com.e.prismetrictestapplication.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolderClass> {
    private Context context;
    private List<ModelList>main_list;
  public AdapterClass( Context context,List<ModelList>main_list){
     this.context=context;
     this.main_list=main_list;

 }


    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.details_list,parent,false);
        return  new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterClass.ViewHolderClass holder, int position) {
             ModelList modelList=main_list.get(position);
             holder.name.setText(modelList.getName());
        holder.email.setText(modelList.getEmail());
        holder.address.setText(modelList.getAddress().getCity());
        holder.com_name.setText(modelList.getCompany().getName());
        holder.website.setText(modelList.getWebsite());
        holder.phone.setText(modelList.getPhone());

        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String lat=main_list.get(position).getAddress().getGeo().getLat();
                String lng=main_list.get(position).getAddress().getGeo().getLng();
                Intent i=new Intent(context, MapsActivity.class);
                i.putExtra("getlat", lat );
                i.putExtra("getlng",lng);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivity(i);

            }
        });



    }

    @Override
    public int getItemCount() {
        return main_list.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
      private TextView name, email, address,com_details,com_name,website,phone;
private LinearLayout main_layout;

        public ViewHolderClass(@NonNull  View itemView) {
            super(itemView);
            main_layout=itemView.findViewById(R.id.main_layout);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            address=itemView.findViewById(R.id.address);
            com_details=itemView.findViewById(R.id.com_details);
            com_name=itemView.findViewById(R.id.com_name);
            website=itemView.findViewById(R.id.website);
            phone=itemView.findViewById(R.id.phone);

        }
    }

}
