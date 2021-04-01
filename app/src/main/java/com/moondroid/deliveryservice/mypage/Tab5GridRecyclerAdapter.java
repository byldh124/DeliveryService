package com.moondroid.deliveryservice.mypage;

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

public class Tab5GridRecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Integer> gridItems;

    public Tab5GridRecyclerAdapter(Context context, ArrayList<Integer> gridItems) {
        this.context = context;
        this.gridItems = gridItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.tab5_grid_recycler_layout,parent,false);
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Picasso.get().load(gridItems.get(position)).into(((VH)holder).iv);
    }

    @Override
    public int getItemCount() {
        return gridItems.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_tab5_grid);
        }
    }
}
