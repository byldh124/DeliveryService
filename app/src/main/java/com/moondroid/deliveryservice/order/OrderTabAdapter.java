package com.moondroid.deliveryservice.order;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moondroid.deliveryservice.favorite.Tab1FavoriteFragment;
import com.moondroid.deliveryservice.favorite.Tab2FavoriteFragment;
import com.moondroid.deliveryservice.favorite.Tab3FavoriteFragment;

public class OrderTabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments;
    String[] titles = new String[]{"배달 포장/방문", "B마트"};

    public OrderTabAdapter(@NonNull FragmentManager fm, int behavior, Fragment[] fragments) {

        super(fm, behavior);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragments[position];
    }

    @Override
    public int getCount() {

        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
