package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class MyOrder extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;
    public static ArrayList<MyOrderClass> dataList = new ArrayList<>();
    private MyOrderClass data;
    private TextView totalPrice, currSaldo;
    private int total, qty, saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        SharedPreferences topUp = getSharedPreferences("topUp", MODE_WORLD_READABLE);
        saldo = topUp.getInt("saldo", 0);
        currSaldo = findViewById(R.id.txtSaldo);
        currSaldo.setText("Your Saldo is : Rp " + saldo);
        SharedPreferences preferences = getSharedPreferences("orderData", MODE_WORLD_READABLE);
        qty = preferences.getInt("qty", 0);
        Intent intent = getIntent();
        int itemCount;
        data = new MyOrderClass(preferences.getString("menuName", null), preferences.getInt("price", 0), qty);
        dataList.add(data);
        Intent intent2 = getIntent();
        total = intent2.getIntExtra("grandTotal", 0);

        recyclerView = (RecyclerView)findViewById(R.id.listProduct);
        adapter = new RecycleViewAdapter(dataList);
        itemCount = adapter.getItemCount();
        if(itemCount == 0){
            dataList = new ArrayList<>();
            Toast.makeText(this, "No Order Yet!", Toast.LENGTH_LONG).show();
        }
        else{
            adapter.notifyDataSetChanged();
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyOrder.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            total = grandTotal(dataList);
            totalPrice = findViewById(R.id.totalPrice);
            totalPrice.setText("Rp " + String.valueOf(total));
        }
    }

    public int grandTotal(ArrayList<MyOrderClass> dataList){
        int totalPrice = 0, totalMenu;
        for(int i=0;i<dataList.size();i++){
            totalMenu = dataList.get(i).getPrice() * qty;
            totalPrice += totalMenu;
        }
        return totalPrice;
    }

    public void btnPayOnClick(View view) {
        if(saldo<total){
            Toast.makeText(this, "Saldo not enough", Toast.LENGTH_SHORT).show();
        }else{
            saldo -= total;
            SharedPreferences preferences = getSharedPreferences("topUp", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("saldo", saldo);
            editor.apply();
            Intent intent = new Intent(this, OrderComplete.class);
            intent.putExtra("grandTotal", total);
            startActivity(intent);
        }
    }
}