package com.moondroid.deliveryservice.what;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moondroid.deliveryservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Tab2StaggeredGridAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Integer> items;

    public Tab2StaggeredGridAdapter(Context context, ArrayList<Integer> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.tab2_grid_recycler_layout,parent,false);
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(items.get(position)).into(((VH)holder).iv);
//        Picasso.get().load(items.get(position)).into(((VH)holder).iv);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.tab2_grid_iv);
        }
    }
}
