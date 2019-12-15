package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.Interface.FoodInterface;
import com.example.dewiiliie.diabetter.handler.ListConsumption;
import com.example.dewiiliie.diabetter.model.ConsumeType;
import com.example.dewiiliie.diabetter.model.Consumption;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements FoodInterface {

    private Context mContext;
    private ArrayList<ConsumeType> mList;
    private ApiInterface mApiInterface;
    private String user_id;
//    private int count;
    private ArrayList<ArrayList<Consumption>> consumptions;
    private ArrayList<Consumption> c;
    private TextView title, addFood, editFood, totalCals;
    private double totalCal;
    private FoodInterface foodInterface;
    private static DecimalFormat df2 = new DecimalFormat("#.##");


    Adapter(Context context, ArrayList<ConsumeType> list,ArrayList<ArrayList<Consumption>> consumptions, FoodInterface foodInterface){
        mContext = context;
        mList = list;
//        count = i;
        this.consumptions = consumptions;
        this.foodInterface = foodInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.add_food,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final ConsumeType foodItem = mList.get(position);
        ImageView image = holder.iv_base;
        totalCal = 0;


        title = holder.tv_title;
        addFood = holder.tv_addFood;
        editFood = holder.tv_editFood;
        totalCals = holder.tv_total_cals;

        ArrayList<Consumption> c = new ArrayList<>();

//        image.setImageResource(foodItem.getImage());

        title.setText(foodItem.getConsumetype_name());
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,Menu_makanan.class);
                intent.putExtra("consumetype_id",position+1);
                mContext.startActivity(intent);
            }
        });

        editFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext,editFoodActivity.class);
                mContext.startActivity(i);

                //Intent intent = new Intent(mContext,editFoodActivity.class);
                //mContext.startActivity(intent);
//                Toast.makeText(mContext, "This feature is unused", Toast.LENGTH_SHORT).show();
            }
        });

        for(int i = 0 ; i < consumptions.get(0).size() ; i ++){
            if ( consumptions.get(0).get(i).getConsumetypeID() ==  Integer.parseInt(mList.get(position).getConsumetype_id())){
                c.add(consumptions.get(0).get(i));
            }
        }

        ArrayList<ChildModel> list = new ArrayList<>(); // ChildModel as ChoosenFood
//        ArrayList<Consumption> consumptions = new ArrayList<>();
        ChildModel childModel = null;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        holder.rv_FoodChoosen.setLayoutManager(layoutManager);
        holder.rv_FoodChoosen.setHasFixedSize(true);
        holder.rv_FoodChoosen.setLayoutManager(new LinearLayoutManager(mContext));
        ChildRecyclerFoodAdapter childRecyclerFoodAdapter = new ChildRecyclerFoodAdapter(c, mContext,this);
        holder.rv_FoodChoosen.setAdapter(childRecyclerFoodAdapter);

//        if(position == 0){ // ChosenFood WHERE consume_type = BREAKFAST
//            //childModel = new ChildModel("Jagung bakar","30","cal");
//            list.add(new ChildModel("Jagung Rebus","10","cal"));
//            list.add(new ChildModel("Jagung Rebusan","12","cal"));
//        }
//        if(position == 1){
//            childModel = new ChildModel("Jagung Rebus","10","cal");
//            list.add(childModel);
//        }
//        if(position == 2){
//            childModel = new ChildModel("Nasi Putih","100","cal");
//            list.add(childModel);
//        }
//        if(position == 3){
//            childModel = new ChildModel("Apel","25","cal");
//            list.add(childModel);
//        }
//        if(position == 4){
//            childModel = new ChildModel("Steak","150","cal");
//            list.add(childModel);
//        }

        int convertedTotalCals = 0;
        for(ChildModel li : list){
            convertedTotalCals += Integer.parseInt(li.calChoosen);
        }
        totalCals.setText(convertedTotalCals+"");
//        ChildModel childModel = new ChildModel("Jagung bakar","30","cal");
        //list.add(childModel);
    }

    @Override
    public int getItemCount() {
        return  mList.size();
    }

    @Override
    public void onAddFood(int foodID, int serving_calories) {

    }

    @Override
    public void onAddCalories(double calories) {
        totalCal += calories;
        totalCals.setText(String.valueOf(df2.format(totalCal)));
        Global.totalCalories += calories;
        foodInterface.totalCalories(Global.totalCalories);

    }

    @Override
    public void totalCalories(double totalCalory) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_base;
        TextView tv_title, tv_addFood, tv_editFood, tv_total_cals;
        RecyclerView rv_FoodChoosen;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_base = itemView.findViewById(R.id.iv_base);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_addFood = itemView.findViewById(R.id.tv_addFood);
            tv_editFood = itemView.findViewById(R.id.tv_editFood);
            tv_total_cals = itemView.findViewById(R.id.tv_total_cals);
            rv_FoodChoosen = itemView.findViewById(R.id.rv_list_makanan_choosen);

        }
    }





//    private List<Model> models;
//    private LayoutInflater layoutInflater;
//    private Context context;
//
//    public Adapter(List<Model> models, Context context) {
//        this.models = models;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return models.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view.equals(object);
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        layoutInflater = LayoutInflater.from(context);
//        View view = layoutInflater.inflate(R.layout.menu_utama, container, false);
//
//        TextView text_view_breakfast;
//        Button button_add;
//
//        button_add = view.findViewById(R.id.button_login);
//        text_view_breakfast = view.findViewById(R.id.text_view_breakfast);
//
//        text_view_breakfast.setText(models.get(position).getText_view_breakfast());
//
//        container.addView(view,0);
//
//        return view;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((View)object);
//    }
}
