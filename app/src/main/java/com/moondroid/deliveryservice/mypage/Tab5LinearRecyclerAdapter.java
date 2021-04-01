package com.moondroid.deliveryservice.mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moondroid.deliveryservice.R;

import java.util.ArrayList;

public class Tab5LinearRecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<String> linearItems;

    public Tab5LinearRecyclerAdapter(Context context, ArrayList<String> linearItems) {
        this.context = context;
        this.linearItems = linearItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.tab5_linear_recycler_layout,parent,false);
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((VH)holder).tvTitle.setText(linearItems.get(position));
        if (position == 0) {
            ((VH)holder).tvSub.setText("배민페이로 결제하면 최대 5.5% 배민포인트가 적립됩니다!");
        }
        
        if (position == 1){
            ((VH)holder).tvSub.setText("결제수단을 공유해 우리 가족의 끼니를 챙겨주세요.");
        }
    }

    @Override
    public int getItemCount() {
        return linearItems.size();
    }

    class VH extends RecyclerView.ViewHolder{
        TextView tvTitle,tvSub;

        public VH(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_linear_tab5);
            tvSub = itemView.findViewById(R.id.tv_sub_linear_tab5);
        }
    }
}
