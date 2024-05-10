package com.ldsr.gametradingplatform.home.buyFrag;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldsr.gametradingplatform.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BuyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyFragment newInstance(String param1, String param2) {
        BuyFragment fragment = new BuyFragment();
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
        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        GoodCategoriesFragment goodCategoriesFragment = new GoodCategoriesFragment();
        GameCategoriesFragment gameCategoriesFragment = new GameCategoriesFragment();

        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.categories_context,gameCategoriesFragment)
                .add(R.id.categories_context,goodCategoriesFragment)
                .hide(gameCategoriesFragment)
                .show(goodCategoriesFragment)
                .commit();

        CardView goodCategories = view.findViewById(R.id.goodcategories);
        CardView gameCategories = view.findViewById(R.id.gamecategories);
        goodCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .hide(gameCategoriesFragment)
                        .show(goodCategoriesFragment)
                        .commit();
            }
        });
        gameCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .hide(goodCategoriesFragment)
                        .show(gameCategoriesFragment)
                        .commit();
            }
        });
        return view;
    }
}