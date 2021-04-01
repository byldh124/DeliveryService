package com.moondroid.deliveryservice.what;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.moondroid.deliveryservice.MainActivity;
import com.moondroid.deliveryservice.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WhatFragment extends Fragment {

    RecyclerView bottomTab2RecyclerView;
    ArrayList<Integer> items;
    Tab2StaggeredGridAdapter adapter;

    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_what, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.tab2_toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        items = new ArrayList<>();

        bottomTab2RecyclerView = view.findViewById(R.id.bottom_tab2_recycler);
        addItems();
        adapter = new Tab2StaggeredGridAdapter(getActivity(), items);
        bottomTab2RecyclerView.setAdapter(adapter);

    }

    public void addItems() {
        items.add(R.drawable.bottomtab2img01);
        items.add(R.drawable.bottomtab2img02);
        items.add(R.drawable.bottomtab2img18);
        items.add(R.drawable.bottomtab2img12);
        items.add(R.drawable.bottomtab2img10);
        items.add(R.drawable.bottomtab2img03);
        items.add(R.drawable.bottomtab2img15);
        items.add(R.drawable.bottomtab2img17);
        items.add(R.drawable.bottomtab2img06);
        items.add(R.drawable.bottomtab2img19);
        items.add(R.drawable.bottomtab2img04);
        items.add(R.drawable.bottomtab2img09);
        items.add(R.drawable.bottomtab2img13);
        items.add(R.drawable.bottomtab2img14);
        items.add(R.drawable.bottomtab2img07);
    }
}
