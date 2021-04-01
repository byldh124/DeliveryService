package com.moondroid.deliveryservice.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.moondroid.deliveryservice.MainActivity;
import com.moondroid.deliveryservice.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    MaterialToolbar toolbar;
    ArrayList<String> toolbarText_items;

    TextView toolbarTextView;
    TabLayout tabLayout;
    FragmentManager fragmentManager;
    NestedScrollView nestedScrollView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTextView = view.findViewById(R.id.toolbar_textView);
        toolbarText_items = new ArrayList<>();
        addToolbarTextItem();
        toolbarTextView.setText(toolbarText_items.get(0) + " ▼");

        tabLayout = view.findViewById(R.id.layout_tab);
        tabLayout.addTab(tabLayout.newTab().setText("배달").setTag("tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("포장/방문").setTag("tab2"));

        nestedScrollView = view.findViewById(R.id.fragmentContainer);

        fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragmentContainer, new Tab1HomeFragment());

        transaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();

                if (pos == 0) {
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new Tab1HomeFragment()).commit();
                    nestedScrollView.setScrollY(0);
                } else {
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new Tab2HomeFragment()).commit();
                    nestedScrollView.setScrollY(0);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void addToolbarTextItem() {
        toolbarText_items.add("서울시 관악구 남부순환로184가길 24");
        toolbarText_items.add("서울시 성동구 홍익동 60");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.option_menu, menu);
    }
}
