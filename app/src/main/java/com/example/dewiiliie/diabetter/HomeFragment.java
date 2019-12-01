package com.example.dewiiliie.diabetter;


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
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dewiiliie.diabetter.handler.GetFoods;
import com.example.dewiiliie.diabetter.handler.UserInformation;
import com.example.dewiiliie.diabetter.model.Food;
import com.example.dewiiliie.diabetter.model.User;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    View v;
    private TextView tv_nama_user,tv_max_calories;
    private RecyclerView recyclerView;
    private ArrayList<Model> addFoodList;
    private ApiInterface mApiInterface;
    private String mFullname;
    private float IMT, BBI,KKB, kriteriaBB, aktivitas, hitungUmur;
    private String typeBBI;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_home,container,false);

        tv_nama_user = (TextView) v.findViewById(R.id.tv_nama_customer);
        tv_max_calories = (TextView) v.findViewById(R.id.tv_max_calories);
        //Set Username
        Bundle b3 = getArguments();
        Bundle extras = getActivity().getIntent().getExtras();
        ArrayList<User> users  = (ArrayList<User>) extras.getSerializable("user");
        User user = users.get(0);
        tv_nama_user.setText(users.get(0).getFull_name());

        //Set RV Food
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_add_food) ;
        Adapter adapter = new Adapter(getContext(),addFoodList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);

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
        }
        else if(user.getGender() == 'F')
        {
            KKB = BBI * 25;
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

        float totalKebutuhanKalori;
        totalKebutuhanKalori = KKB + hitungUmur + kriteriaBB + aktivitas;
        tv_max_calories.setText(String.valueOf(totalKebutuhanKalori));


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

}
