package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    private ArrayList<String> mFoodName = new ArrayList<>();
    private ArrayList<String> mCalories = new ArrayList<>();
    private Context mContext;

    public FoodAdapter(Context mContext, ArrayList<String> mFoodName, ArrayList<String> mCalories) {
        this.mFoodName = mFoodName;
        this.mCalories = mCalories;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View foodView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_food,parent,false);

        return new MyViewHolder(foodView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.foodName.setText(mFoodName.get(position));
        holder.calories.setText(mCalories.get(position));
        holder.food_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(FoodAdapter.this,edit_qty_food.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFoodName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, calories;
        RelativeLayout food_layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.text_view_food_name);
            calories = itemView.findViewById(R.id.text_view_calories);
            food_layout = itemView.findViewById(R.id.list_food_layout);
        }
    }




}
