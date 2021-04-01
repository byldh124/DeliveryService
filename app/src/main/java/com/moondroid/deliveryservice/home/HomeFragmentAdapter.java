package com.moondroid.deliveryservice.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeFragmentAdapter extends FragmentPagerAdapter {

    Fragment[] fragments;
    String[] titles = new String[]{"배달","포장/방문"};
    public HomeFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm,behavior);
        fragments = new Fragment[]{new Tab1HomeFragment(), new Tab2HomeFragment()};
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
