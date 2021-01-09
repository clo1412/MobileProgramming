package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
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

    public void btnMineralOnClick(View view) {
        Intent intent = new Intent(this, OrderDetail.class);
        Bundle b = new Bundle();
        b.putInt("menu",1);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void btnApelOnClick(View view) {
        Intent intent = new Intent(this, OrderDetail.class);
        Bundle b = new Bundle();
        b.putInt("menu",2);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void btnMangoOnClick(View view) {
        Intent intent = new Intent(this, OrderDetail.class);
        Bundle b = new Bundle();
        b.putInt("menu",3);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void btnAvocadoOnClick(View view) {
        Intent intent = new Intent(this, OrderDetail.class);
        Bundle b = new Bundle();
        b.putInt("menu",4);
        intent.putExtras(b);
        startActivity(intent);
    }

}