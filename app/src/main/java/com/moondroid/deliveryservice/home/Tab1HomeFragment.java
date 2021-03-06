package com.moondroid.deliveryservice.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.moondroid.deliveryservice.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Tab1HomeFragment extends Fragment {

    ViewPager autoScrollViewPager;
    ArrayList<Integer> data = new ArrayList<>();
    int currentPage = 0;
    Timer timer;

    ArrayList<Integer> categories = new ArrayList<>();
    FoodCategoryAdapter foodCategoryAdapter;
    RecyclerView foodCategories_recycler;

    ArrayList<Integer> brands = new ArrayList<>();
    RecyclerView brands_recycler;
    BrandsAdapter brandsAdapter;

    ArrayList<StoreItem> storeItems = new ArrayList<>();
    RecyclerView store_recycler;
    StoresAdapter storesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_tab1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //AutoScroll
        autoScrollViewPager = view.findViewById(R.id.autoViewPager);
        addItem();
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(getContext(), data);
        autoScrollViewPager.setAdapter(scrollAdapter);

        Handler handler = new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                currentPage = autoScrollViewPager.getCurrentItem();
                currentPage++;
                autoScrollViewPager.setCurrentItem(currentPage, true);

                if (currentPage == data.size()) {
                    autoScrollViewPager.setCurrentItem(0);
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

        //Category Recycler
        foodCategories_recycler = view.findViewById(R.id.recycler_menu);
        addCategories();
        foodCategoryAdapter = new FoodCategoryAdapter(getActivity(), categories);
        foodCategories_recycler.setAdapter(foodCategoryAdapter);

        //Brand Recycler
        brands_recycler = view.findViewById(R.id.recycler_brand);
        addBrands();
        brandsAdapter = new BrandsAdapter(getActivity(),brands);
        brands_recycler.setAdapter(brandsAdapter);

        //Store Recycler
        store_recycler = view.findViewById(R.id.store_recycler);
        addStoreItems();
        storesAdapter = new StoresAdapter(getActivity(),storeItems);
        store_recycler.setAdapter(storesAdapter);
    }

    public void addStoreItems(){
        storeItems.add(new StoreItem(R.drawable.store01,"????????????","19~29???","????????????. ??????, ???????????? ??????"));
        storeItems.add(new StoreItem(R.drawable.store02,"????????? ????????????","34~44???","?????? ????????? ?????? ???????????? ????????????"));
        storeItems.add(new StoreItem(R.drawable.store03,"????????????","24~34???","???????????? ?????????. ???????????? ??????"));
        storeItems.add(new StoreItem(R.drawable.store04,"????????????????","45~55???","??????, ??????, ????????????, ????????????"));
        storeItems.add(new StoreItem(R.drawable.store05,"????????????","15~25???","?????????, ?????????, ?????????, ?????????, ??????"));
        storeItems.add(new StoreItem(R.drawable.store06,"?????????","38~48???","?????? ????????? ????????? ?????? ????????? ?????? ?????????"));
        storeItems.add(new StoreItem(R.drawable.store07,"????????? ??????","43~53???","??????, ??????????????? ?????? ?????? ?????? 1??? ??????"));
    }

    public void addItem() {
        data.add(R.drawable.banner2);
        data.add(R.drawable.banner3);
        data.add(R.drawable.banner4);
        data.add(R.drawable.banner5);
        data.add(R.drawable.banner1);
        data.add(R.drawable.banner6);
        data.add(R.drawable.banner7);
        data.add(R.drawable.banner8);
    }

    public void addBrands() {
        brands.add(R.drawable.brand01);
        brands.add(R.drawable.brand02);
        brands.add(R.drawable.brand03);
        brands.add(R.drawable.brand04);
        brands.add(R.drawable.brand05);
        brands.add(R.drawable.brand06);
    }

    public void addCategories() {
        categories.add(R.drawable.hansik);
        categories.add(R.drawable.bunsik);
        categories.add(R.drawable.ilsik);
        categories.add(R.drawable.chicken);
        categories.add(R.drawable.pizza);
        categories.add(R.drawable.chinese);
        categories.add(R.drawable.bossam);
        categories.add(R.drawable.yasik);
        categories.add(R.drawable.tang);
        categories.add(R.drawable.dosirak);
        categories.add(R.drawable.cafe);
        categories.add(R.drawable.fastfood);
        categories.add(R.drawable.prancise);
        categories.add(R.drawable.ranking);
        categories.add(R.drawable.empty);
        categories.add(R.drawable.empty);
    }
}
