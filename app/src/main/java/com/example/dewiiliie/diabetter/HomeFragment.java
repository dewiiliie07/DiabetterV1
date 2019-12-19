package com.example.dewiiliie.diabetter;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.Interface.FoodInterface;
import com.example.dewiiliie.diabetter.handler.GetFoods;
import com.example.dewiiliie.diabetter.handler.ListConsumeType;
import com.example.dewiiliie.diabetter.handler.ListConsumption;
import com.example.dewiiliie.diabetter.handler.UserInformation;
import com.example.dewiiliie.diabetter.model.ConsumeType;
import com.example.dewiiliie.diabetter.model.Consumption;
import com.example.dewiiliie.diabetter.model.Food;
import com.example.dewiiliie.diabetter.model.ListQuest;
import com.example.dewiiliie.diabetter.model.ListQuestCounter;
import com.example.dewiiliie.diabetter.model.Quest;
import com.example.dewiiliie.diabetter.model.TotalConsumptionUser;
import com.example.dewiiliie.diabetter.model.User;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dewiiliie.diabetter.Global.user;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements FoodInterface {


    View v;
    private TextView tv_nama_user,tv_max_calories, tv_jumlah_calories;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ArrayList<Model> addFoodList;
    private ApiInterface mApiInterface;
    private String mFullname;
    private float IMT, BBI,KKB, kriteriaBB, aktivitas, hitungUmur;
    private String typeBBI;
    private ArrayList<ConsumeType> consumeTypes;
    private int countConsumption;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private FoodInterface foodInterface;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        foodInterface = this;
        Global.totalCalories = 0;

//        checkQuest();

        v = inflater.inflate(R.layout.fragment_home,container,false);

        tv_nama_user = (TextView) v.findViewById(R.id.tv_nama_customer);
        tv_max_calories = (TextView) v.findViewById(R.id.tv_max_calories);
        tv_jumlah_calories = (TextView) v.findViewById(R.id.tv_jumlah_calories);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        //Set Username



//        tv_nama_user.setText(user.getFull_name());

        //Set TotalCalory




        //Set Max Calories

        float tinggiBadanMeter = user.getHeight()/100;
        IMT  = user.getWeight()/(tinggiBadanMeter*tinggiBadanMeter);
        if (user.getHeight()>=160){
            BBI = user.getHeight() - 100 - ((user.getHeight()-100)*10/100);
            System.out.println("MASUK diatas 160");
        }
        else {
            BBI = (user.getHeight() -100)*1;
            System.out.println("MASUK dibawah 160");
        }

        if (user.getWeight() < (BBI*90/100)){
            typeBBI = "kurus";
        }
        else if (user.getWeight() > (BBI*90/100) && user.getWeight() <= (BBI*110/100)){
            typeBBI = "normal";
        }
        else if (user.getWeight() > (BBI*110/100) && user.getWeight() <= (BBI*120/100)){
            typeBBI = "gemuk";
        }
        else if (user.getWeight() > (BBI*120/100)){
            typeBBI = "obesitas";
        }

        if (user.getGender() == 'M'){
            KKB = BBI * 30;
            tv_nama_user.setText("Mr. " + user.getFull_name());
        }
        else if(user.getGender() == 'F')
        {
            KKB = BBI * 25;
            tv_nama_user.setText("Ms. " +user.getFull_name());
        }
        int umur = Calendar.getInstance().get(Calendar.YEAR) - Integer.valueOf(user.getBirthdate().substring(0,4));

        if (umur>=40 && umur<59){
            hitungUmur = - (KKB*5/100);
        }
        else if (umur>=60 && umur<69){
            hitungUmur = - (KKB*10/100);
        }
        else if (umur>= 70){
            hitungUmur = - (KKB*20/100);
        }

        if (typeBBI.equals("kurus")){
            kriteriaBB = (KKB*20/100);
        }
        else if (typeBBI.equals("gemuk")){
            kriteriaBB = - (KKB*20/100);
        }
        else if (typeBBI.equals("obesitas")){
            kriteriaBB = - (KKB*30/100);
        }

        if (user.getActivity_level() == 'I') {
            aktivitas = (KKB*10/100);
        }
        else if(user.getActivity_level() == 'R'){
            aktivitas = (KKB*20/100);
        }
        else if(user.getActivity_level() == 'S'){
            aktivitas = (KKB*30/100);
        }
        else if(user.getActivity_level() == 'B'){
            aktivitas = (KKB*40/100);
        }
//        else if(user.getActivity_level() == 'SB'){
//            KKB = KKB + (30%KKB);
//        }
        System.out.println("KKB : " + KKB);
        System.out.println("BBI : " + BBI);
        System.out.println("Umur : " + umur);
        System.out.println("Hitung Umur : " + hitungUmur);
        System.out.println("Kriteria BB : " + kriteriaBB + " Type : " + typeBBI);
        System.out.println("AKtivitas " + aktivitas);

        final float totalKebutuhanKalori;
        totalKebutuhanKalori = KKB + hitungUmur + kriteriaBB + aktivitas;

        final Call<TotalConsumptionUser> totalCalories = mApiInterface.getTotalCaloriesUser(user.getUser_id());
        totalCalories.enqueue(new Callback<TotalConsumptionUser>() {
            @Override
            public void onResponse(Call<TotalConsumptionUser> call, Response<TotalConsumptionUser> response) {
                TotalConsumptionUser total = response.body();
                tv_jumlah_calories.setText(String.valueOf(df2.format(total.caloriesTotal())));
//
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                    progressBar.setMin(0);
                    progressBar.setMax((int)totalKebutuhanKalori);
                    progressBar.setProgress((int)total.caloriesTotal());
                    if ((int)total.caloriesTotal()>(int)totalKebutuhanKalori){
                        Drawable progressDrawable = progressBar.getProgressDrawable().mutate();
                        progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                        progressBar.setProgressDrawable(progressDrawable);
                    }
                }
//                progressBar.setProgress(50);
            }

            @Override
            public void onFailure(Call<TotalConsumptionUser> call, Throwable t) {
                Toast.makeText(getContext(),"Error : " + t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                System.out.println("Error : " + t.getMessage().toString());
            }
        });
        tv_max_calories.setText(String.valueOf(totalKebutuhanKalori));


        //Create RecyclerView Foods
//        Call<ListConsumeType> callConsumeType = mApiInterface.getConsumeType();
//        callConsumeType.enqueue(new Callback<ListConsumeType>() {
//            @Override
//            public void onResponse(Call<ListConsumeType> call, Response<ListConsumeType> response) {
//                consumeTypes = response.body().getConsumeTypes();
//                System.out.println("CONSUME TYPE COUNT : "+ consumeTypes.size());
//                final ArrayList<ArrayList<Consumption>> listConsumptions = new ArrayList<>();
//                for (int i = 0; i< consumeTypes.size() ; i++) {
//                    final ApiInterface mApiInterface2 = ApiClient.getClient().create(ApiInterface.class);
////                    countConsumption = i+1;
//                    Call<ListConsumption> foodConsumption = mApiInterface2.getConsumption(user.getId(),i+1);
//                    foodConsumption.enqueue(new Callback<ListConsumption>() {
//                        @Override
//                        public void onResponse(Call<ListConsumption> call, Response<ListConsumption> response) {
//                            ArrayList<Consumption> consumption = response.body().getConsumptions();
//                            listConsumptions.add(consumption);
//                            System.out.println("CONSUMPTION : "+ consumption.size());
//                            recyclerView = (RecyclerView) v.findViewById(R.id.rv_add_food) ;
//                            Adapter adapter = new Adapter(getContext(),consumeTypes,listConsumptions);
//                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
//                            recyclerView.setAdapter(adapter);
//                        }
//
//                        @Override
//                        public void onFailure(Call<ListConsumption> call, Throwable t) {
//                            Toast.makeText(getContext(),"ERROR "+ t.getMessage(),Toast.LENGTH_SHORT).show();
//                            System.out.println("ERROR " + t.getMessage());
//                        }
//                    });
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ListConsumeType> call, Throwable t) {
//
//            }
//        });

        //2nd
        Call<ListConsumeType> callConsumeType = mApiInterface.getConsumeType();
        callConsumeType.enqueue(new Callback<ListConsumeType>() {
            @Override
            public void onResponse(Call<ListConsumeType> call, Response<ListConsumeType> response) {
                consumeTypes = response.body().getConsumeTypes();
                System.out.println("CONSUME TYPE COUNT : "+ consumeTypes.size());
                final ArrayList<ArrayList<Consumption>> listConsumptions = new ArrayList<>();
                final ApiInterface mApiInterface2 = ApiClient.getClient().create(ApiInterface.class);
//                    countConsumption = i+1;
                Call<ListConsumption> foodConsumption = mApiInterface2.getConsumptionByUser(user.getUser_id());
                foodConsumption.enqueue(new Callback<ListConsumption>() {
                    @Override
                    public void onResponse(Call<ListConsumption> call, Response<ListConsumption> response) {
                        ArrayList<Consumption> consumption = response.body().getConsumptions();
                        listConsumptions.add(consumption);
                        System.out.println("CONSUMPTION : "+ consumption.size());
                        recyclerView = (RecyclerView) v.findViewById(R.id.rv_add_food) ;
                        Adapter adapter = new Adapter(getContext(),consumeTypes,listConsumptions, foodInterface);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<ListConsumption> call, Throwable t) {
                        Toast.makeText(getContext(),"ERROR "+ t.getMessage(),Toast.LENGTH_SHORT).show();
                        System.out.println("ERROR " + t.getMessage());
                    }
                });
            }

            @Override
            public void onFailure(Call<ListConsumeType> call, Throwable t) {

            }
        });
        //Call getFood
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFoodList = new ArrayList<>();

        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Breakfast","Add Food","edit text"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Breakfast Snacks","Add Food","edit text"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Lunch","Add Food","edit text"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Lunch Snacks","Add Food","edit text"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Dinner","Add Food","edit text"));

    }

    @Override
    public void onAddFood(int foodID, int serving_calories) {

    }

    @Override
    public void onAddCalories(double calories) {

    }

    @Override
    public void totalCalories(double totalCalory) {
//        tv_jumlah_calories.setText(String.valueOf(df2.format(totalCalory)));
    }


}
