package com.moondroid.deliveryservice.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;

import com.moondroid.deliveryservice.R;


import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MapActivity extends AppCompatActivity {

    MapView mapView;
    RelativeLayout mapContainer;
    ViewPager viewPager;
    AutoScrollAdapter scrollAdapter;
    ArrayList<Integer> datas = new ArrayList<>();
    int currentItem = 0;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = new MapView(this);

        mapContainer = findViewById(R.id.map_container);
        mapContainer.addView(mapView);
        viewPager = findViewById(R.id.map_view_pager);
        addDatas();
        scrollAdapter = new AutoScrollAdapter(this, datas);
        viewPager.setAdapter(scrollAdapter);

        Handler handler = new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                currentItem = viewPager.getCurrentItem();
                currentItem++;
                viewPager.setCurrentItem(currentItem, true);

                if (currentItem == datas.size()) {
                    viewPager.setCurrentItem(0);
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 500, 3000);

    }

    public void addDatas(){
        datas.add(R.drawable.scrollviewimg01);
        datas.add(R.drawable.scrollviewimg02);
        datas.add(R.drawable.scrollviewimg03);
    }
}