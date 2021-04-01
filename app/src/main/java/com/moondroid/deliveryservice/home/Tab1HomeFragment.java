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
        storeItems.add(new StoreItem(R.drawable.store01,"삼시세끼","19~29분","한식전문. 찌개, 제육볶음 추천"));
        storeItems.add(new StoreItem(R.drawable.store02,"또와라 닭볶음탕","34~44분","한번 먹으면 두번 먹고싶은 닭볶음탕"));
        storeItems.add(new StoreItem(R.drawable.store03,"미친제육","24~34분","제육볶음 전문점. 맵기조절 가능"));
        storeItems.add(new StoreItem(R.drawable.store04,"이게니족발?","45~55분","족발, 보쌈, 쟁반국수, 보쌈김치"));
        storeItems.add(new StoreItem(R.drawable.store05,"분식나라","15~25분","분식류, 식사류, 찌개류, 돈까스, 면류"));
        storeItems.add(new StoreItem(R.drawable.store06,"밥치킨","38~48분","한번 먹어본 사람은 절대 끊을수 없는 밥치킨"));
        storeItems.add(new StoreItem(R.drawable.store07,"푸짐한 밥상","43~53분","혼술, 혼밥족들을 위한 한상 가득 1인 밥상"));
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
