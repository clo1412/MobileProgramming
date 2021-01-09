package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderComplete extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewAdapter2 adapter;
    private ArrayList<MyOrderClass> dataList = MyOrder.dataList;
    private int total, qty;
    TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        int itemCount;
        Intent intent = getIntent();

        recyclerView = (RecyclerView)findViewById(R.id.listProduct2);
        adapter = new RecycleViewAdapter2(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OrderComplete.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        total = intent.getIntExtra("grandTotal", 0);
        totalPrice = findViewById(R.id.totalPrice);
        totalPrice.setText("Total : Rp " + String.valueOf(total));
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        dataList.clear();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}