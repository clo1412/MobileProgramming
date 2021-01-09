package com.example.ezyfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.ViewHolder> {

    protected ArrayList<MyOrderClass> dataList = MyOrder.dataList;
    int menuTotal;

    public RecycleViewAdapter2(ArrayList<MyOrderClass> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecycleViewAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_list2, parent, false);
        menuTotal = 0;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter2.ViewHolder holder, int position) {
        if(getItemCount()!=0){
            menuTotal = dataList.get(position).getPrice() * dataList.get(position).getQty();
            holder.menuName.setText(dataList.get(position).getMenuName());
            holder.price.setText("Rp " + String.valueOf(menuTotal));
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView menuName, price;
        public ViewHolder(@NonNull View item){
            super(item);
            menuName = item.findViewById(R.id.txtMenuName);
            price = item.findViewById(R.id.txtPrice);
        }
    }
}
