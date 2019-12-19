package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.model.Consumption;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit2.Call;

public class EditFoodAdapter extends RecyclerView.Adapter<EditFoodAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Consumption> consumptions;
    private int user_consumption_id;

    public EditFoodAdapter(Context context , ArrayList<Consumption> consumptions) {
        this.mContext = context;
        this.consumptions = consumptions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_edit_food,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_food_name.setText(consumptions.get(position).getFoodname());
        holder.tv_serving_calories.setText(String.valueOf(consumptions.get(position).getServing_calories()));
        double calory_total = (double)consumptions.get(position).getCalories()/consumptions.get(position).getServing_calory() * consumptions.get(position).getServing_calories();
        DecimalFormat df = new DecimalFormat("#.##");
        String result = df.format(calory_total);

        holder.tv_total_calories.setText(result);

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_consumption_id = consumptions.get(position).getUser_consumption_id();
                consumptions.remove(position);
                notifyItemRemoved(position);
                new Connection2().execute();
            }
        });

    }

    public class Connection2 extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            Call<String> delete_consumption = Global.mApi.delete_consumption(Global.user.getUser_id(), user_consumption_id);
            try{
                delete_consumption.execute();
            }catch (Exception ex){
                ex.printStackTrace();
                Toast.makeText(mContext, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return consumptions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Button btn_delete;
        TextView tv_total_calories,tv_food_name, tv_serving_calories;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_total_calories = (TextView) itemView.findViewById(R.id.tv_total_calories);
            tv_food_name = (TextView) itemView.findViewById(R.id.tv_food_name);
            tv_serving_calories = (TextView) itemView.findViewById(R.id.tv_serving_calories);
            btn_delete = (Button) itemView.findViewById(R.id.btn_delete);
        }
    }
}
