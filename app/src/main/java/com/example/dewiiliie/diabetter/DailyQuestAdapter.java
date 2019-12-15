package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dewiiliie.diabetter.model.Quest;

import java.util.ArrayList;

public class DailyQuestAdapter extends RecyclerView.Adapter<DailyQuestAdapter.ViewHolder> {

    private ArrayList<Quest> quests;
    private Context mContext;

    public DailyQuestAdapter(Context context, ArrayList<Quest> quests) {
        this.mContext = context;
        this.quests = quests;
    }

    @Override
    public DailyQuestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_daily_quest,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyQuestAdapter.ViewHolder holder, int position) {
        if (quests.get(position).getIsDone()==1){
            holder.cv_header.setVisibility(View.GONE);
            holder.cv_header2.setVisibility(View.VISIBLE);
            holder.txt_quest_name2.setText(quests.get(position).getQuest_name());
            holder.txt_point2.setText(String.valueOf(quests.get(position).getQuest_point()));
        }
        else {
            holder.cv_header2.setVisibility(View.GONE);
            holder.cv_header.setVisibility(View.VISIBLE);
            holder.txt_quest_name.setText(quests.get(position).getQuest_name());
            holder.txt_point.setText(String.valueOf(quests.get(position).getQuest_point()));
            int resId = mContext.getResources().getIdentifier(quests.get(position).getImage_name(), "drawable", mContext.getPackageName());
            holder.icon_reward.setImageResource(resId);

        }
        System.out.println("ISI DARI R.DRAWABLE " + R.drawable.badge1 );
        String mDrawableName = "badge1";
        int resId = mContext.getResources().getIdentifier(mDrawableName , "drawable", mContext.getPackageName());
        System.out.println("ISI DARI R " + resId);

    }

    @Override
    public int getItemCount() {
        return quests.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_quest_name, txt_point,txt_quest_name2, txt_point2;
        CardView cv_header2,cv_header;
        ImageView icon_reward;
        public ViewHolder(View itemView) {
            super(itemView);
            txt_quest_name = itemView.findViewById(R.id.txt_questName);
            txt_point = itemView.findViewById(R.id.txt_point);
            cv_header2 = itemView.findViewById(R.id.cv_header2);
            cv_header = itemView.findViewById(R.id.cv_header);
            txt_quest_name2 = itemView.findViewById(R.id.txt_questName2);
            txt_point2 = itemView.findViewById(R.id.txt_point2);
            icon_reward = itemView.findViewById(R.id.icon_reward);
        }
    }
}
