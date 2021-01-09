package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class OrderDetail extends AppCompatActivity {

    String menuNameTemp;
    int count = 0, menu, priceTemp;
    TextView qty ;
    ImageView image;
    TextView menuName, price;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        Intent intent = getIntent();
        menu = intent.getIntExtra("menu",0);
        image = (ImageView) findViewById(R.id.prodImage);
        menuName = (TextView) findViewById(R.id.txtMenuName);
        price = (TextView) findViewById(R.id.txtPrice);
        if(menu == 1){
            image.setBackgroundResource(R.drawable.mineral_water);
            menuName.setText("Air Mineral");
            price.setText("Rp 5000");
        }
        if(menu == 2){
            image.setBackgroundResource(R.drawable.juice);
            menuName.setText("Jus Apel");
            price.setText("Rp 10000");
        }
        if(menu == 3){
            image.setBackgroundResource(R.drawable.mango);
            menuName.setText("Jus Mangga");
            price.setText("Rp 12000");
        }
        if(menu == 4){
            image.setBackgroundResource(R.drawable.orange_juice);
            menuName.setText("Jus Alpukat");
            price.setText("Rp 11000");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent2 = new Intent(this, MyOrder.class);
        startActivity(intent2);
        return super.onOptionsItemSelected(item);
    }

    public void btnPlusOnClick(View view) {
        qty = findViewById(R.id.qty);
        count += 1;
        qty.setText(String.valueOf(count));
    }

    public void btnMinOnClick(View view) {
        qty = findViewById(R.id.qty);
        if(count == 0){
            Toast.makeText(this, "cannot les than 1!", Toast.LENGTH_SHORT).show();
        }
        else{
            count -= 1;
            qty.setText(String.valueOf(count));
        }
    }

    public void btnAddOnClick(View view) {
        int quantity = Integer.parseInt(qty.getText().toString());

        if(quantity == 0){
            Toast.makeText(this,"Quantity cannot 0!", Toast.LENGTH_SHORT).show();
        }else {
            addData();
            Toast.makeText(this,"Added to Cart!", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnOrderMoreOnClick(View view) { qty = (TextView) findViewById(R.id.qty);
        finish();
    }

    void addData(){
        menuName = (TextView) findViewById(R.id.txtMenuName);
        final String menuNameTxt;
        final int qtyFinal = Integer.parseInt(qty.getText().toString()), priceInt;
        if(menuName.getText().equals("Air Mineral")){
            menuNameTemp = "Air Mineral";
            priceTemp = 5000;
        }
        if(menuName.getText().equals("Jus Apel")){
            menuNameTemp = "Jus Apel";
            priceTemp = 10000;
        }
        if(menuName.getText().equals("Jus Mangga")){
            menuNameTemp = "Jus Mangga";
            priceTemp = 12000;
        }
        if(menuName.getText().equals("Jus Alpukat")){
            menuNameTemp = "Jus Alpukat";
            priceTemp = 11000;
        }
        menuNameTxt = menuNameTemp;
        priceInt = priceTemp;
        SharedPreferences preferences = getSharedPreferences("orderData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("menuName", menuNameTxt);
        editor.putInt("price", priceInt);
        editor.putInt("qty", qtyFinal);
        editor.apply();
    }

}