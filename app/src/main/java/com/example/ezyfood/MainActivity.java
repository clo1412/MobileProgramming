package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int currSaldo=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView saldo = findViewById(R.id.txtSaldo);
        SharedPreferences topUp = getSharedPreferences("topUp", MODE_WORLD_READABLE);
        currSaldo = topUp.getInt("saldo", 0);
        if(currSaldo!=0)
            saldo.setText("Your Saldo: Rp " + currSaldo);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void btnDrinkOnClick(View view) {
        Intent intent = new Intent(this, DrinksActivity.class);
        startActivity(intent);
    }

    public void btnTopUpOnClick(View view) {
        Intent intent = new Intent(this, TopUp.class);
        startActivity(intent);
    }

    public void btnLocationOnClick(View view) {
        Intent intent = new Intent(this, RestaurantLocation.class);
        startActivity(intent);
    }
}