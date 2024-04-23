package com.ldsr.gametradingplatform.home;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.ldsr.gametradingplatform.R;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    Map<ConstraintLayout, Fragment> layoutToFragmentMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Init();


        // 为每个布局设置点击监听器
        for (Map.Entry<ConstraintLayout, Fragment> entry : layoutToFragmentMap.entrySet()) {
            ConstraintLayout layout = entry.getKey();
            Fragment targetFragment = entry.getValue();

            layout.setOnClickListener(v -> {
                // 隐藏所有片段
                for (Fragment fragment : layoutToFragmentMap.values()) {
                    hideFragment(fragment);
                }
                // 激活目标片段
                showFragment(targetFragment);

                // 设置点击的布局为选中状态，其他布局为非选中状态
                for (ConstraintLayout registeredLayout : layoutToFragmentMap.keySet()) {
                    registeredLayout.setSelected(registeredLayout == layout);
                }
            });
        }
    }

    private void Init() {
        // 添加布局和片段到映射中
        layoutToFragmentMap.put(getDelegate().findViewById(R.id.homeLayout), new HomeFragment());
        layoutToFragmentMap.put(getDelegate().findViewById(R.id.buyLayout), new BuyFragment());
        layoutToFragmentMap.put(getDelegate().findViewById(R.id.saleLayout), new SaleFragment());
        layoutToFragmentMap.put(getDelegate().findViewById(R.id.shopCarLayout), new ShopCarFragment());
        layoutToFragmentMap.put(getDelegate().findViewById(R.id.userLayout), new UserFragment());


        // 设置初始状态
        for (ConstraintLayout layout : layoutToFragmentMap.keySet()) {
            addFragment(layoutToFragmentMap.get(layout));
            if (layout.getId() == R.id.homeLayout) {
                layout.setSelected(true);
                showFragment(layoutToFragmentMap.get(layout));
            } else {
                hideFragment(layoutToFragmentMap.get(layout));
            }
        }
    }

    private void showFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().show(f).commit();
    }

    private void hideFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().hide(f).commit();
    }

    private void addFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, f).commit();
    }
}