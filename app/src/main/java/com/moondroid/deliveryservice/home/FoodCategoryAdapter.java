package com.moondroid.deliveryservice.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moondroid.deliveryservice.R;

import java.util.ArrayList;

public class FoodCategoryAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Integer> categories;

    public FoodCategoryAdapter(Context context, ArrayList<Integer> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.foodcategotylist_recycler_layout,parent,false);
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((VH)holder).iv.setImageResource(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.recycler_img);
        }
    }
}
