package com.moondroid.deliveryservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moondroid.deliveryservice.favorite.FavoriteFragment;
import com.moondroid.deliveryservice.home.HomeFragment;
import com.moondroid.deliveryservice.mypage.MyPageFragment;
import com.moondroid.deliveryservice.order.OrderFragment;
import com.moondroid.deliveryservice.what.WhatFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;
    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        fragments = new Fragment[5];
        fragmentManager = getSupportFragmentManager();
        fragments[0] = new HomeFragment();

        fragmentManager.beginTransaction().add(R.id.mainContainer, fragments[0]).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                for (int i = 0; i < fragments.length; i++) {
                    if (fragments[i] != null) {
                        transaction.hide(fragments[i]);
                    }
                }

                switch (id) {
                    case R.id.bnv_home:
                        if (fragments[0] == null) {
                            fragments[0] = new HomeFragment();
                            transaction.add(R.id.mainContainer, fragments[0]);
                        }
                        transaction.show(fragments[0]);

                        break;
                    case R.id.bnv_what:
                        if (fragments[1] == null) {
                            fragments[1] = new WhatFragment();
                            transaction.add(R.id.mainContainer, fragments[1]);
                        }
                        transaction.show(fragments[1]);
                        break;
                    case R.id.bnv_favorite:
                        if (fragments[2] == null) {
                            fragments[2] = new FavoriteFragment();
                            transaction.add(R.id.mainContainer, fragments[2]);
                        }
                        transaction.show(fragments[2]);
                        break;
                    case R.id.bnv_order:
                        if (fragments[3] == null) {
                            fragments[3] = new OrderFragment();
                            transaction.add(R.id.mainContainer, fragments[3]);
                        }
                        transaction.show(fragments[3]);
                        break;
                    case R.id.bnv_my_page:
                        if (fragments[4] == null) {
                            fragments[4] = new MyPageFragment();
                            transaction.add(R.id.mainContainer, fragments[4]);
                        }
                        transaction.show(fragments[4]);
                        break;
                }

                transaction.commit();

                return true;
            }
        });
    }
}