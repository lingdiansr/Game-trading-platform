package com.ldsr.gametradingplatform.home.buyFrag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ldsr.gametradingplatform.R;
import com.ldsr.gametradingplatform.entity.GoodListItem;

import java.util.ArrayList;
import java.util.List;

public class GoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_good_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView back = findViewById(R.id.imageView63);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        List<GoodListItem> listItems= new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            listItems.add(new GoodListItem());
        }
        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(listItems);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
        List<GoodListItem> data;

        public MyAdapter(List<GoodListItem> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(GoodListActivity.this)
                    .inflate(R.layout.item_buy_goodlist,parent,false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//            Glide.with(GoodListActivity.this)
//                    .load(data.get(position).getImgURL())
//                    .into(holder.img);
//            holder.title.setText(data.get(position).getTitle());
//            holder.price.setText(String.format("￥%f",data.get(position).getPrice()));
//            holder.num.setText(String.format("%d人查看",data.get(position).getNum()));
            holder.main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GoodListActivity.this, ProductDetailsActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        private class MyHolder extends RecyclerView.ViewHolder{
            ConstraintLayout main;
            ImageView img;
            TextView title;
            TextView price;
            TextView num;
            public MyHolder(@NonNull View itemView) {
                super(itemView);
                main=itemView.findViewById(R.id.goodlistitem);
                img=itemView.findViewById(R.id.imageView7);
                title=itemView.findViewById(R.id.textView140);
                price=itemView.findViewById(R.id.textView142);
                num=itemView.findViewById(R.id.textView143);
            }
        }
    }
}