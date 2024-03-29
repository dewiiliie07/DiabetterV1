package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.Interface.FoodInterface;
import com.example.dewiiliie.diabetter.model.Food;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    private static Context mContext; // awalnya ga static
    private EditText ed_serving_cal;
    private TextView tv_addFood, tv_rmFood;
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<String> mCalories = new ArrayList<>();
    static ArrayList<Food> addedFood = new ArrayList<>();
    private FoodInterface foodI;
    //private Context mContext;

    public FoodAdapter(Context mContext, ArrayList<Food> foods, FoodInterface foodI) {
        this.foods = foods;
//        this.mCalories = mCalories;
        this.mContext = mContext;
        this.foodI = foodI;
    }

    static void getFood(){
        Toast.makeText(mContext, addedFood.toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View foodView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_food,parent,false);
        return new MyViewHolder(foodView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.foodName.setText(foods.get(position).getName().toString());
        holder.calories.setText(String.valueOf(foods.get(position).getCalories()));

        holder.btnAdd.setText("+");
        holder.ed_serv_cal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                /*Float cal = Float.parseFloat(charSequence.toString()) * Float.parseFloat(mCalories.get(position));
                if(charSequence.length() == 0){
                    for (String food : addedFood) {
                        addedFood.remove(food);
                    }
                }*/
                //Toast.makeText(mContext, "beforeTextChange", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                /*if(charSequence.length() == 0){
                    for (String food : addedFood) {
                        addedFood.remove(food);
                    }
                }*/
                if(charSequence.length() != 0){
//                    foodI.onAddFood(foods.get(position).getId(), Integer.parseInt(charSequence.toString()));
//                    Float cal = Float.parseFloat(charSequence.toString()) * Float.parseFloat(mCalories.get(position));
//
//                    if(addedFood.isEmpty()){
//                        addedFood.add(foods.get(position));
//
//                    }
//                    else{
//                        for (Food food: addedFood){
//                            if(mFoodName.get(position).equals(food.substring(0, mFoodName.get(position).length()))){ // kalo makanan yg di klik, sama kyak yg di added
//                                //update
//                                //hapus+add
//                                addedFood.remove(food);
//                                break;
//                            }
//                        }
//                        addedFood.add(mFoodName.get(position)+" "+cal);
//                    }
                    //Toast.makeText(mContext, addedFood.toString(), Toast.LENGTH_SHORT).show();
//                    AddFood
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Toast.makeText(mContext, editable.toString(), Toast.LENGTH_SHORT).show();
//                if (editable.toString().length() == 0 ){
//                    for (String food : addedFood){
//                        if(mFoodName.get(position).equals(food.substring(0, mFoodName.get(position).length()))){
//                            //Toast.makeText(mContext, food, Toast.LENGTH_SHORT).show();
//                            addedFood.remove(food);
//                        }
//                    }
//                }
                if (!holder.ed_serv_cal.getText().toString().equals("")){
                    foodI.onAddFood(foods.get(position).getId(), Integer.valueOf(holder.ed_serv_cal.getText().toString()));
                }

            }
        });
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ed_serv_cal.setVisibility(View.VISIBLE);
                holder.btnAdd.setVisibility(View.INVISIBLE);
                holder.btnRemove.setVisibility(View.VISIBLE);
                //addedFood.add(mFoodName.get(position)+" "+(Float.parseFloat(mCalories.get(position))* Float.parseFloat(ed_serving_cal.getText().toString())));
                // belum bisa karena ed_serv_cal msih invisible,
                // cari tau gimana biar klik visible, edit, baru confirm
                holder.ed_serv_cal.setText(String.valueOf(foods.get(position).getServing_calories()));
                foodI.onAddFood(foods.get(position).getId(), Integer.valueOf(holder.ed_serv_cal.getText().toString()));
                Toast.makeText(mContext, addedFood.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ed_serv_cal.setText("");
                holder.ed_serv_cal.setVisibility(View.INVISIBLE);
                holder.btnAdd.setVisibility(View.VISIBLE);
                holder.btnRemove.setVisibility(View.INVISIBLE);
                foodI.onAddFood(foods.get(position).getId(), 0);
                //addedFood.remove(position);
                Toast.makeText(mContext, addedFood.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void filterList(ArrayList<Food> filteredList){
        foods = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, calories, btnAdd, btnRemove;
        EditText ed_serv_cal;
//        RecyclerView rv_FoodChoosen;


        //RelativeLayout food_layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.text_view_food_name);
            calories = itemView.findViewById(R.id.text_view_calories);
            btnAdd = itemView.findViewById(R.id.tv_addFood);
            btnRemove = itemView.findViewById(R.id.tv_rmFood);
            ed_serv_cal = itemView.findViewById(R.id.ed_serving_cal);
//            rv_FoodChoosen = itemView.findViewById(R.id.rv_list_makanan_choosen);
            //food_layout = itemView.findViewById(R.id.list_food_layout);
        }
    }

}
