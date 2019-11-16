package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChildRecyclerFoodAdapter extends RecyclerView.Adapter<ChildRecyclerFoodAdapter.MyViewHolder> {

    private List<ChildModel> childModels;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public ChildRecyclerFoodAdapter(List<ChildModel> childModels, Context mContext) {
        this.childModels = childModels;
        this.mContext = mContext;
        this.layoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_food_choosen,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChildModel model = childModels.get(position);
        holder.tvFoodChoosenChild.setText(model.getFoodName());
        holder.tvCaloriesChoosen.setText(model.getCalChoosen());
        holder.tvCal.setText(model.getCal());
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
            tvCal = itemView.findViewById(R.id.tv_cal);
            tvCaloriesChoosen = itemView.findViewById(R.id.tv_calories_choosen);
        }
    }

}
