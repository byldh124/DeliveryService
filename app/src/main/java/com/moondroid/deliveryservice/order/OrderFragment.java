package com.moondroid.deliveryservice.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.moondroid.deliveryservice.MainActivity;
import com.moondroid.deliveryservice.R;
import com.moondroid.deliveryservice.favorite.FavoriteTabAdapter;

public class OrderFragment extends Fragment {

    FragmentManager fragmentManager;
    OrderTabAdapter pagerAdapter;
    ViewPager viewPager;
    Fragment[] fragments;

    TabLayout tabLayout;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar_order);
        tabLayout = view.findViewById(R.id.layout_tab_order);

        fragments = new Fragment[2];
        fragments[0] = new Tab1OrderFragment();
        fragments[1] = new Tab2OrderFragment();

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = view.findViewById(R.id.bottom_tab4_viewpager);
        fragmentManager = getActivity().getSupportFragmentManager();
        pagerAdapter = new OrderTabAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
