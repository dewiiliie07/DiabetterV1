package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dewiiliie.diabetter.Interface.FoodInterface;
import com.example.dewiiliie.diabetter.model.Consumption;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChildRecyclerFoodAdapter extends RecyclerView.Adapter<ChildRecyclerFoodAdapter.MyViewHolder> {

    private ArrayList<Consumption> childModels;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private int consumetypeID;
    private FoodInterface foodInterface;
    private static DecimalFormat df2 = new DecimalFormat("#.##");


    public ChildRecyclerFoodAdapter(ArrayList<Consumption> childModels, Context mContext, FoodInterface foodInterface) {
        this.childModels = childModels;
        this.mContext = mContext;
        this.layoutInflater=LayoutInflater.from(mContext);
        this.foodInterface = foodInterface;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_food_choosen,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Consumption model = childModels.get(position);
        holder.tvFoodChoosenChild.setText(model.getFoodname());
        holder.tvCaloriesChoosen.setText(String.valueOf(model.getServing_calory()));
        double calory_total = (double)model.getCalories()/model.getServing_calory() * model.getServing_calories();
        foodInterface.onAddCalories(calory_total);
        holder.tvCal.setText(String.valueOf(df2.format(calory_total)));
    }

    @Override
    public int getItemCount() {
        return childModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvFoodChoosenChild, tvCal, tvCaloriesChoosen;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvFoodChoosenChild = itemView.findViewById(R.id.tv_food_choosen_child);
            tvCal = itemView.findViewById(R.id.tv_calories_choosen);
            tvCaloriesChoosen = itemView.findViewById(R.id.tv_calories_choosen);
        }
    }

}
