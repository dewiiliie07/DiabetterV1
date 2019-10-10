package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Model> mList;
    Adapter(Context context, ArrayList<Model> list){
        mContext = context;
        mList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.add_food,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Model foodItem = mList.get(position);
        ImageView image = holder.iv_base;
        TextView title, addFood;

        title = holder.tv_title;
        addFood = holder.tv_addFood;

        image.setImageResource(foodItem.getImage());

        title.setText(foodItem.getTitle());
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,Menu_makanan.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return  mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_base;
        TextView tv_title, tv_addFood;
        public ViewHolder(View itemView) {
            super(itemView);

            iv_base = itemView.findViewById(R.id.iv_base);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_addFood = itemView.findViewById(R.id.tv_addFood);

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
