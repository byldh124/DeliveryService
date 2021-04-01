package com.moondroid.deliveryservice.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moondroid.deliveryservice.R;

import java.util.ArrayList;

public class StoresAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<StoreItem> storeItems;

    public StoresAdapter(Context context, ArrayList<StoreItem> storeItems) {
        this.context = context;
        this.storeItems = storeItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.store_recycler_layout,parent,false);
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH viewHolder = (VH)holder;
        Glide.with(context).load(storeItems.get(position).storeImgId).into(viewHolder.iv);
        viewHolder.tvName.setText(storeItems.get(position).name);
        viewHolder.tvMinute.setText(storeItems.get(position).minute);
        viewHolder.tvSummary.setText(storeItems.get(position).summary);

    }

    @Override
    public int getItemCount() {
        return storeItems.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tvName, tvMinute, tvSummary;
        public VH(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.store_list_iv);
            tvName = itemView.findViewById(R.id.store_tv_name);
            tvMinute = itemView.findViewById(R.id.store_tv_minute);
            tvSummary = itemView.findViewById(R.id.store_tv_summary);
        }
    }
}
