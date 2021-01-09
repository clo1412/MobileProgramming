package com.example.ezyfood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    protected ArrayList<MyOrderClass> dataList = MyOrder.dataList;
    int menuTotal;

    public RecycleViewAdapter(ArrayList<MyOrderClass> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_list, parent, false);
        menuTotal = 0;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, final int position) {
        if(getItemCount()!=0){
            menuTotal = dataList.get(position).getPrice() * dataList.get(position).getQty();
            holder.menuName.setText(dataList.get(position).getMenuName());
            holder.price.setText("Rp " + String.valueOf(menuTotal));
            holder.Hapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView menuName, price;
        Button Hapus;
        public ViewHolder(@NonNull View item){
            super(item);
            menuName = item.findViewById(R.id.txtMenuName);
            price = item.findViewById(R.id.txtPrice);
            Hapus = item.findViewById(R.id.btnHapus);
        }
    }
}
