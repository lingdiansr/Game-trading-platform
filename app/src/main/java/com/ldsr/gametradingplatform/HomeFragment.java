package com.ldsr.gametradingplatform;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ldsr.gametradingplatform.entity.GoodItem;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    List<GoodItem> goodItemList = new ArrayList<>();
    List<String> switchingText =new ArrayList<>();
    Timer timer;

    int textSwitcherNum=0;
    TextSwitcher textSwitcher;

//    List<String> gameContent= new ArrayList<>();
    Map<TextView,String> gameContent =new HashMap<>();
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initBanner(view);
        initTextSwitcher(view);
        initGameContent(view);
        initRecyclerView(view);

        return view;
    }

    private void initGameContent(View view) {
        List<String> values= new ArrayList<>();
        List<TextView> keys =new ArrayList<>();
        values.add("王者荣耀");
        values.add("航海王");
        values.add("神武4");
        values.add("火影忍者");
        values.add("口袋妖怪");
        values.add("穿越火线");
        values.add("闪烁之光");
        values.add("仙境传说");
        values.add("率土之滨");
        values.add("少年三国志");
        values.add("三国志");
        values.add("阿拉德之怒");
        keys.add(view.findViewById(R.id.textView9));
        keys.add(view.findViewById(R.id.textView10));
        keys.add(view.findViewById(R.id.textView11));
        keys.add(view.findViewById(R.id.textView12));
        keys.add(view.findViewById(R.id.textView15));
        keys.add(view.findViewById(R.id.textView16));
        keys.add(view.findViewById(R.id.textView17));
        keys.add(view.findViewById(R.id.textView18));
        keys.add(view.findViewById(R.id.textView19));
        keys.add(view.findViewById(R.id.textView20));
        keys.add(view.findViewById(R.id.textView21));
        keys.add(view.findViewById(R.id.textView22));
        for (int i = 0; i < 12; i++) {
            gameContent.put(keys.get(i),values.get(i));

        }
        for (TextView textView : gameContent.keySet()) {
            textView.setText(gameContent.get(textView));
        }
    }

    private void initTextSwitcher(View view) {
        switchingText.add("汪峰 购买了 41041金1988钻 ￥0.01");
        switchingText.add("孙悟空 购买了 4464601金988钻 ￥10.01");
        switchingText.add("红孩儿 购买了 41316441金2488钻 ￥100.01");
        switchingText.add("哪吒 购买了 346041金1588钻 ￥1000.01");
        textSwitcher= view.findViewById(R.id.textswitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setMaxLines(1);
                textView.setTextSize(15);
                textView.setTextColor(Color.BLACK);
                textView.setLayoutParams(
                        new FrameLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return textView;
            }

        });
        textSwitcher.setText(switchingText.get(0));
        Handler handler =new Handler();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                textSwitcherNum=++textSwitcherNum%switchingText.size();
                textSwitcher.setText(switchingText.get(textSwitcherNum));
                handler.postDelayed(this,2000);
            }
        };
        handler.postDelayed(task,2000);
    }

    private void initRecyclerView(View view) {
        for (int i = 0; i < 8; i++) {
            GoodItem goodItem = new GoodItem();
            goodItem.setImgUrl("app/src/main/res/drawable/gameicon.png");
            goodItem.setGoodTitle("王者荣耀最强王者段位全英雄全皮肤");
            goodItem.setPrice(280);
            goodItem.setPurchasedNumber(11);
            goodItem.setGameName("王者荣耀");
            goodItemList.add(goodItem);
        }

        RecyclerView recyclerView = view.findViewById(R.id.goodsRecyclerView);
        recyclerView.setAdapter(new MyAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    private static void initBanner(View view) {
        List<Integer> bannerList = new ArrayList<>();
//        bannerList.add("https://www.hnucm.edu.cn/images/dongtangxiaoqu.jpg");
        bannerList.add(R.drawable.banner);
        bannerList.add(R.drawable.banner);

        Banner banner = view.findViewById(R.id.banner);
        banner.setAdapter(new BannerImageAdapter<Integer>(bannerList) {
            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                Glide.with(holder.itemView).load(data)
                        .into(holder.imageView);
            }
        });
        banner.setIndicator(new CircleIndicator(view.getContext()));
        banner.setIndicatorRadius(100);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleTextView;
        TextView priceTextView;
        TextView purchasedNumberTextView;
        TextView gameNameTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.gameImage);
            titleTextView=itemView.findViewById(R.id.itemTitle);
            priceTextView=itemView.findViewById(R.id.price);
            purchasedNumberTextView=itemView.findViewById(R.id.purchasedNumber);
            gameNameTextView=itemView.findViewById(R.id.gameName);
        }
    }
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.goods_item_layout,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            GoodItem goodItem = goodItemList.get(position);
//            Glide.with(getContext())
//                    .load(goodItem.getImgUrl())
//                    .into(holder.imageView);
            holder.titleTextView.setText(goodItem.getGoodTitle());
            holder.priceTextView.setText("￥"+goodItem.getPrice());
            holder.purchasedNumberTextView.setText(goodItem.getPurchasedNumber()+"人已购买");
            holder.gameNameTextView.setText(goodItem.getGameName());
        }

        @Override
        public int getItemCount() {
            return goodItemList.size();
        }
    }

}