package com.moondroid.deliveryservice.mypage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.moondroid.deliveryservice.MainActivity;
import com.moondroid.deliveryservice.R;

import java.util.ArrayList;

public class MyPageFragment extends Fragment {

    Toolbar toolbar;

    ArrayList<Integer> gridItems = new ArrayList<>();

    Tab5GridRecyclerAdapter gridRecyclerAdapter;
    RecyclerView gridRecyclerView,linearRecyclerView;

    ArrayList<String> linearItems = new ArrayList<>();
    Tab5LinearRecyclerAdapter linearRecyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_page,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_my_page);

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        gridRecyclerView = view.findViewById(R.id.recycler_tab5_grid);
        addGridItems();
        gridRecyclerAdapter = new Tab5GridRecyclerAdapter(getActivity(),gridItems);
        gridRecyclerView.setAdapter(gridRecyclerAdapter);

        linearRecyclerView = view.findViewById(R.id.recycler_tab5_linear);
        addLinearItems();
        linearRecyclerAdapter = new Tab5LinearRecyclerAdapter(getActivity(),linearItems);
        linearRecyclerView.setAdapter(linearRecyclerAdapter);




    }

    public void addGridItems(){
        gridItems.add(R.drawable.tab5_point);
        gridItems.add(R.drawable.tab5_coupon);
        gridItems.add(R.drawable.tab5_present);
        gridItems.add(R.drawable.tab5_jjim);
        gridItems.add(R.drawable.tab5_order);
        gridItems.add(R.drawable.tab5_review);
    }

    public void addLinearItems(){
        linearItems.add("배민페이 등록");
        linearItems.add("가족계정 관리");
        linearItems.add("선물하기");
        linearItems.add("공지사항");
        linearItems.add("배민커넥트 지원");
        linearItems.add("이벤트");
        linearItems.add("환경설정");
        linearItems.add("약관 및 정책");
        linearItems.add("현재버전 10.19.0");
    }
}
