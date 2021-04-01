package com.moondroid.deliveryservice.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.moondroid.deliveryservice.MainActivity;
import com.moondroid.deliveryservice.R;

public class FavoriteFragment extends Fragment {

    Toolbar toolbar;
    TabLayout tabLayout;
    FragmentManager fragmentManager;
    FavoriteTabAdapter pagerAdapter;

    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_favorite);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = view.findViewById(R.id.layout_tab_favorite);

        viewPager = view.findViewById(R.id.bottom_tab3_viewpager);

        fragmentManager = getActivity().getSupportFragmentManager();
        pagerAdapter = new FavoriteTabAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }
}
