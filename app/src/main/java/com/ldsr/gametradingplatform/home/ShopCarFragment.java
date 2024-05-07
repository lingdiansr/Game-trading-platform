package com.ldsr.gametradingplatform.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldsr.gametradingplatform.R;
import com.ldsr.gametradingplatform.entity.ShopCarGoodItem;
import com.ldsr.gametradingplatform.entity.ShopCarShopItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopCarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShopCarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopCarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopCarFragment newInstance(String param1, String param2) {
        ShopCarFragment fragment = new ShopCarFragment();
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
    List<ShopCarShopItem> shopItems =new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_car, container, false);
        initRecyclerViewData();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.shopsView);
        ShopCarAdapter shopCarAdapter = new ShopCarAdapter(shopItems);
        recyclerView.setAdapter(shopCarAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initRecyclerViewData() {
        List<ShopCarGoodItem> shopCarGoodItems=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ShopCarGoodItem shopCarGoodItem = new ShopCarGoodItem();
            shopCarGoodItem.setSelected(true);
            shopCarGoodItem.setTitle("3600万金币=100.00元【绿色商品安全迅速】");
            shopCarGoodItem.setShippingForm("手动发货");
            shopCarGoodItem.setPrice(530);
            shopCarGoodItem.setNumber(0);
            shopCarGoodItems.add(shopCarGoodItem);
        }
        ShopCarShopItem shopCarShopItem = new ShopCarShopItem();
        shopCarShopItem.setSelected(false);
        shopCarShopItem.setShopName("子墨无敌店");
        shopCarShopItem.setShopCarGoods(shopCarGoodItems);
        shopItems.add(shopCarShopItem);

        shopCarShopItem = new ShopCarShopItem();
        shopCarShopItem.setSelected(false);
        shopCarShopItem.setShopName("牛魔王店");
        shopCarGoodItems=new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            ShopCarGoodItem shopCarGoodItem = new ShopCarGoodItem();
            shopCarGoodItem.setSelected(true);
            shopCarGoodItem.setTitle("3600万金币=100.00元【绿色商品安全迅速】");
            shopCarGoodItem.setShippingForm("手动发货");
            shopCarGoodItem.setPrice(530);
            shopCarGoodItem.setNumber(0);
            shopCarGoodItems.add(shopCarGoodItem);
        }
        shopCarShopItem.setShopCarGoods(shopCarGoodItems);
        shopItems.add(shopCarShopItem);

        shopCarShopItem = new ShopCarShopItem();
        shopCarShopItem.setSelected(false);
        shopCarShopItem.setShopName("铁扇公主店");
        shopCarGoodItems=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ShopCarGoodItem shopCarGoodItem = new ShopCarGoodItem();
            shopCarGoodItem.setSelected(true);
            shopCarGoodItem.setTitle("3600万金币=100.00元【绿色商品安全迅速】");
            shopCarGoodItem.setShippingForm("手动发货");
            shopCarGoodItem.setPrice(530);
            shopCarGoodItem.setNumber(0);
            shopCarGoodItems.add(shopCarGoodItem);
        }
        shopCarShopItem.setShopCarGoods(shopCarGoodItems);
        shopItems.add(shopCarShopItem);
    }


    public class ShopCarGoodAdapter extends RecyclerView.Adapter<ShopCarGoodAdapter.ShopCarGoodViewHolder>{
        private List<ShopCarGoodItem> shopCarGoodItems;

        public ShopCarGoodAdapter(List<ShopCarGoodItem> shopCarGoodItems) {
            this.shopCarGoodItems = shopCarGoodItems;
        }

        @NonNull
        @Override
        public ShopCarGoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(getContext())
                    .inflate(R.layout.item_shopcar_goods,parent,false);
            return new ShopCarGoodViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ShopCarGoodViewHolder holder, int position) {
            holder.checkBox.setSelected(shopCarGoodItems.get(position).isSelected());
//            Glide.with(getContext())
//                    .load(shopCarGoodItems.get(position).getImgUrl())
//                    .into(holder.imageView);
            holder.title.setText(shopCarGoodItems.get(position).getTitle());
            holder.ShippingForm.setText("发货方式："+shopCarGoodItems.get(position).getShippingForm());
            holder.price.setText(String.format("￥ %.2f",shopCarGoodItems.get(position).getPrice()));
            holder.number.setText(""+shopCarGoodItems.get(position).getNumber());
        }

        @Override
        public int getItemCount() {
            return shopCarGoodItems.size();
        }

        public class ShopCarGoodViewHolder extends RecyclerView.ViewHolder{
            CheckBox checkBox;
            ImageView imageView;
            TextView title;
            TextView ShippingForm;
            TextView price;
            TextView number;
            public ShopCarGoodViewHolder(@NonNull View itemView) {
                super(itemView);
                checkBox=itemView.findViewById(R.id.ShopCarGoodCheckBox);
                imageView=itemView.findViewById(R.id.ShopCarGoodImg);
                title=itemView.findViewById(R.id.ShopCarGoodTitle);
                ShippingForm=itemView.findViewById(R.id.ShopCarGoodShippingForm);
                price=itemView.findViewById(R.id.ShopCarGoodPrice);
                number=itemView.findViewById(R.id.ShopCarGoodNumbers);
            }
        }
    }
    public class ShopCarAdapter extends RecyclerView.Adapter<ShopCarAdapter.ShopCarViewHolder>{
        private List<ShopCarShopItem> shopItems;

        public ShopCarAdapter(List<ShopCarShopItem> shopItems) {
            this.shopItems = shopItems;
        }

        @NonNull
        @Override
        public ShopCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =LayoutInflater.from(getContext())
                    .inflate(R.layout.item_shopcar_shops,parent,false);
            return new ShopCarViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ShopCarViewHolder holder, int position) {
            holder.checkBox.setSelected(shopItems.get(position).isSelected());
            holder.textView.setText(shopItems.get(position).getShopName());
            ShopCarGoodAdapter shopCarGoodAdapter = new ShopCarGoodAdapter(shopItems.get(position).getShopCarGoods());
            holder.recyclerView.setAdapter(shopCarGoodAdapter);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        @Override
        public int getItemCount() {
            return shopItems.size();
        }

        public class ShopCarViewHolder extends RecyclerView.ViewHolder{
            CheckBox checkBox;
            TextView textView;
            RecyclerView recyclerView;
            public ShopCarViewHolder(@NonNull View itemView) {
                super(itemView);
                checkBox=itemView.findViewById(R.id.shopCheckBox);
                textView=itemView.findViewById(R.id.shopname);
                recyclerView=itemView.findViewById(R.id.shopGoodRecyclerView);

            }
        }
    }


}