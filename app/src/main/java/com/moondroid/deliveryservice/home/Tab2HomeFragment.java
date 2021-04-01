package com.moondroid.deliveryservice.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.moondroid.deliveryservice.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Tab2HomeFragment extends Fragment {

    ViewPager autoScrollViewPager;
    ArrayList<Integer> data = new ArrayList<>();
    int currentPage = 0;
    Timer timer;

    ArrayList<Integer> categories = new ArrayList<>();
    FoodCategoryAdapter foodCategoryAdapter;
    RecyclerView foodCategories_recycler;

    ArrayList<StoreItem> storeItems = new ArrayList<>();
    RecyclerView brands_recycler;
    StoresAdapter storesAdapter;

    ArrayList<StoreItem> storeItems2 = new ArrayList<>();
    RecyclerView store_recycler;
    StoresAdapter storesAdapter2;

    ImageView mapIv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_tab2,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapIv = view.findViewById(R.id.map_iv);

        mapIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });

        foodCategories_recycler = view.findViewById(R.id.recycler_menu);
        addCategories();
        foodCategoryAdapter = new FoodCategoryAdapter(getActivity(), categories);
        foodCategories_recycler.setAdapter(foodCategoryAdapter);

        //AutoScroll
        autoScrollViewPager = view.findViewById(R.id.autoViewPager);
        addItem();
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(getContext(), data);
        autoScrollViewPager.setAdapter(scrollAdapter);

        Handler handler = new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == data.size()) {
                    currentPage = 0;
                }
                autoScrollViewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 500, 3000);

        //Brand Recycler
        brands_recycler = view.findViewById(R.id.recycler_brand);
        addBrands();
        storesAdapter = new StoresAdapter(getActivity(),storeItems);
        brands_recycler.setAdapter(storesAdapter);

        //Store Recycler
        store_recycler = view.findViewById(R.id.store_recycler);
        addStoreItems();
        storesAdapter2 = new StoresAdapter(getActivity(),storeItems2);
        store_recycler.setAdapter(storesAdapter2);
    }

    public void addItem() {
        data.add(R.drawable.promotion01);
        data.add(R.drawable.promotion02);
        data.add(R.drawable.promotion03);
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
    }

    public void addBrands() {
        storeItems.add(new StoreItem(R.drawable.store01,"삼시세끼","19~29분","한식전문. 찌개, 제육볶음 추천"));
        storeItems.add(new StoreItem(R.drawable.store02,"또와라 닭볶음탕","34~44분","한번 먹으면 두번 먹고싶은 닭볶음탕"));
        storeItems.add(new StoreItem(R.drawable.store03,"미친제육","24~34분","제육볶음 전문점. 맵기조절 가능"));
        storeItems.add(new StoreItem(R.drawable.store04,"이게니족발?","45~55분","족발, 보쌈, 쟁반국수, 보쌈김치"));

    }

    public void addStoreItems(){
        storeItems2.add(new StoreItem(R.drawable.store05,"분식나라","15~25분","분식류, 식사류, 찌개류, 돈까스, 면류"));
        storeItems2.add(new StoreItem(R.drawable.store06,"밥치킨","38~48분","한번 먹어본 사람은 절대 끊을수 없는 밥치킨"));
        storeItems2.add(new StoreItem(R.drawable.store07,"푸짐한 밥상","43~53분","혼술, 혼밥족들을 위한 한상 가득 1인 밥상"));
    }
}
