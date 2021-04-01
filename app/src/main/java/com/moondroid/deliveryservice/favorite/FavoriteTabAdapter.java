package com.moondroid.deliveryservice.favorite;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FavoriteTabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments;
    String[] titles = new String[]{"찜한가게", "바로결제","전화주문"};

    public FavoriteTabAdapter(@NonNull FragmentManager fm) {

        super(fm);
        fragments = new Fragment[]{new Tab1FavoriteFragment(), new Tab2FavoriteFragment(), new Tab3FavoriteFragment()};
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
