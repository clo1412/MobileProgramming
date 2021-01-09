package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TopUp extends AppCompatActivity {

    private int currSaldo = 0;
    private EditText a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        TextView saldo = findViewById(R.id.txtSaldo);
        SharedPreferences topUp = getSharedPreferences("topUp", MODE_WORLD_READABLE);
        currSaldo = topUp.getInt("saldo", 0);
        if(currSaldo!=0)
            saldo.setText("Rp. " + currSaldo);
    }

    public void btnTopUpOnClick(View view) {
        a = findViewById(R.id.inputSaldo);
        currSaldo = Integer.parseInt(a.getText().toString());
        SharedPreferences preferences = getSharedPreferences("topUp", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("saldo", currSaldo);
        editor.apply();
        Toast.makeText(this,"Top Up Success!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("saldo", currSaldo);
        startActivity(intent);
    }
}