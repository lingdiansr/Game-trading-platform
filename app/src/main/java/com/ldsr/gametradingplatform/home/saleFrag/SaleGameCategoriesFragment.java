package com.ldsr.gametradingplatform.home.saleFrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldsr.gametradingplatform.R;
import com.ldsr.gametradingplatform.entity.GameCategoriesGameItem;
import com.ldsr.gametradingplatform.home.buyFrag.BuyGameCategoriesFragment;
import com.ldsr.gametradingplatform.home.buyFrag.GoodListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaleGameCategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaleGameCategoriesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SaleGameCategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaleGameCategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaleGameCategoriesFragment newInstance(String param1, String param2) {
        SaleGameCategoriesFragment fragment = new SaleGameCategoriesFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sale_game_categories, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.salegamecategoriesrecycler);
        List<GameCategoriesGameItem> datas = new ArrayList<>();
        String[] names={
                "王者荣耀",
                "航海王",
                "神武4",
                "火影忍者",
                "口袋妖怪",
                "穿越火线",
                "闪烁之光",
                "仙境传说",
                "率土之滨",
                "少年三国志",
                "三国志",
                "阿拉德之怒"
        };
        for (String name : names) {
            GameCategoriesGameItem gameCategoriesGameItem = new GameCategoriesGameItem();
            gameCategoriesGameItem.setName(name);
            datas.add(gameCategoriesGameItem);
        }
        SaleGameCategoriesFragment.MyAdaptor myAdaptor = new SaleGameCategoriesFragment.MyAdaptor(datas);
        recyclerView.setAdapter(myAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
    private class MyAdaptor extends RecyclerView.Adapter<SaleGameCategoriesFragment.MyAdaptor.MyHolder>{

        private List<GameCategoriesGameItem> data;

        public MyAdaptor(List<GameCategoriesGameItem> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public SaleGameCategoriesFragment.MyAdaptor.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(getContext())
                    .inflate(R.layout.item_buy_gamecategories,parent,false);
            return new SaleGameCategoriesFragment.MyAdaptor.MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SaleGameCategoriesFragment.MyAdaptor.MyHolder holder, int position) {
            holder.gameName.setText(data.get(position).getName());
//            Glide.with(getContext())
//                    .load(data.get(position).getIconURL())
//                    .into(holder.gameIcon);
            holder.gotoInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), PublishActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        private class MyHolder extends RecyclerView.ViewHolder{
            ImageView gameIcon;
            TextView gameName;
            ImageView gotoInfo;
            public MyHolder(@NonNull View itemView) {
                super(itemView);
                gameIcon=itemView.findViewById(R.id.gameIcon);
                gameName=itemView.findViewById(R.id.buy_gameName);
                gotoInfo=itemView.findViewById(R.id.imageView62);
            }
        }
    }
}