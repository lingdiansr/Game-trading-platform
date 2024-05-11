package com.ldsr.gametradingplatform;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ldsr.gametradingplatform.home.HomeActivity;
import com.ldsr.gametradingplatform.home.buyFrag.GoodListActivity;
import com.ldsr.gametradingplatform.home.buyFrag.ProductDetailsActivity;
import com.ldsr.gametradingplatform.login.LoginActivity;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(getDelegate().findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        Intent intent = new Intent(MainActivity.this, SignInActivity.class);
//        Intent intent = new Intent(MainActivity.this, GoodListActivity.class);
//        Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);


        startActivity(intent);
    }


}