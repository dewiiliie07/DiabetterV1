package com.example.dewiiliie.diabetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AchievementActivity extends AppCompatActivity {
    private ImageView iv_back_buttom;
    private ImageView iv_badge1, iv_badge2,iv_badge3,iv_badge4, iv_badge5, iv_badge6,
            iv_badge7,iv_badge8,iv_badge9,iv_badge10,iv_badge11,iv_badge12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        iv_badge1 = (ImageView) findViewById(R.id.badge1);
        iv_badge2 = (ImageView) findViewById(R.id.badge2);
        iv_badge3 = (ImageView) findViewById(R.id.badge3);
        iv_badge4 = (ImageView) findViewById(R.id.badge4);
        iv_badge5 = (ImageView) findViewById(R.id.badge5);
        iv_badge6 = (ImageView) findViewById(R.id.badge6);
        iv_badge7 = (ImageView) findViewById(R.id.badge7);
        iv_badge8 = (ImageView) findViewById(R.id.badge8);
        iv_badge9 = (ImageView) findViewById(R.id.badge9);
        iv_badge10 = (ImageView) findViewById(R.id.badge10);
        iv_badge11 = (ImageView) findViewById(R.id.badge11);
        iv_badge12 = (ImageView) findViewById(R.id.badge12);

        iv_back_buttom = (ImageView) findViewById(R.id.back_buttom);
        iv_back_buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (Global.quest.get(8).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(8).getImage_name(), "drawable", getPackageName());
            iv_badge1.setImageResource(resId);
        }
        if (Global.quest.get(9).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(9).getImage_name(), "drawable", getPackageName());
            iv_badge2.setImageResource(resId);
        }
        if (Global.quest.get(11).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(11).getImage_name(), "drawable", getPackageName());
            iv_badge3.setImageResource(resId);
        }
        if (Global.quest.get(12).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(12).getImage_name(), "drawable", getPackageName());
            iv_badge4.setImageResource(resId);
        }
        if (Global.quest.get(13).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(13).getImage_name(), "drawable", getPackageName());
            iv_badge5.setImageResource(resId);
        }
        if (Global.quest.get(14).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(14).getImage_name(), "drawable", getPackageName());
            iv_badge6.setImageResource(resId);
        }
        if (Global.quest.get(15).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(15).getImage_name(), "drawable", getPackageName());
            iv_badge7.setImageResource(resId);
        }
        if (Global.quest.get(16).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(16).getImage_name(), "drawable", getPackageName());
            iv_badge8.setImageResource(resId);
        }
        if (Global.quest.get(17).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(17).getImage_name(), "drawable", getPackageName());
            iv_badge9.setImageResource(resId);
        }
        if (Global.quest.get(18).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(18).getImage_name(), "drawable", getPackageName());
            iv_badge10.setImageResource(resId);
        }
        if (Global.quest.get(19).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(19).getImage_name(), "drawable", getPackageName());
            iv_badge11.setImageResource(resId);
        }
        if (Global.quest.get(20).getIsDone()==1) {
            int resId = getResources().getIdentifier(Global.quest.get(20).getImage_name(), "drawable", getPackageName());
            iv_badge12.setImageResource(resId);
        }




    }
}
