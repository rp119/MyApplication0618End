package com.kgy.project_0518;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AttendanceActivity extends AppCompatActivity {
    int subject=0;
    String Name1="file1";
    String Name2="file2";

    int getSubject;
    int informday;
    int toeicday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance);

        TextView Dday  = (TextView)findViewById(R.id.Dday);
        Button homebtn = (Button)findViewById(R.id.homebtn);
        Button btn[] = new Button[101];
        Integer btnId[] = {R.id. day0, R.id.day1, R.id.day2, R.id.day3, R.id.day4, R.id.day5, R.id.day6, R.id.day7, R.id.day8, R.id.day9, R.id.day10,
                R.id.day11, R.id.day12, R.id.day13, R.id.day14, R.id.day15, R.id.day16, R.id.day17, R.id.day18, R.id.day19, R.id.day20,
                R.id.day21, R.id.day22, R.id.day23, R.id.day24, R.id.day25, R.id.day26, R.id.day27, R.id.day28, R.id.day29, R.id.day30,
                R.id.day31, R.id.day32, R.id.day33, R.id.day34, R.id.day35, R.id.day36, R.id.day37, R.id.day38, R.id.day39, R.id.day40,
                R.id.day41, R.id.day42, R.id.day43, R.id.day44, R.id.day45, R.id.day46, R.id.day47, R.id.day48, R.id.day49, R.id.day50,
                R.id.day51, R.id.day52, R.id.day53, R.id.day54, R.id.day55, R.id.day56, R.id.day57, R.id.day58, R.id.day59, R.id.day60,
                R.id.day61, R.id.day62, R.id.day63, R.id.day64, R.id.day65, R.id.day66, R.id.day67, R.id.day68, R.id.day69, R.id.day70,
                R.id.day71, R.id.day72, R.id.day73, R.id.day74, R.id.day75, R.id.day76, R.id.day77, R.id.day78, R.id.day79, R.id.day80,
                R.id.day81, R.id.day82, R.id.day83, R.id.day84, R.id.day85, R.id.day86, R.id.day87, R.id.day88, R.id.day89, R.id.day90,
                R.id.day91, R.id.day92, R.id.day93, R.id.day94, R.id.day95, R.id.day96, R.id.day97, R.id.day98, R.id.day99, R.id.day100};

        for(int i = 0; i<btnId.length; i++) {
            final int index;
            index = i;
            btn[index] = findViewById(btnId[index]);
        }

        int loadtday = gettday();
        int loadiday = getiday();


        Intent intent = getIntent();

        getSubject = intent.getIntExtra("Subject",0); //토익, 정처기 구분
        informday = intent.getIntExtra("Day2",0); //해당 Day가 저장
        toeicday = intent.getIntExtra("Day",0); //해당 Day가 저장

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



        if(getSubject==1) {
            informday = getiday();
            Toast.makeText(getApplicationContext(), "진행한 토익 day = " + toeicday, Toast.LENGTH_SHORT).show();
            if(toeicday>=loadtday){
                loadtday = toeicday;
                savePreferences();
            }
        }
        else if(getSubject==2) {
            toeicday = gettday();
            Toast.makeText(getApplicationContext(), "진행한 전산 day = " + informday, Toast.LENGTH_SHORT).show();
            if(informday>=loadiday){
                loadiday = informday;
                savePreferences();
            }
        }

        if(loadtday<=loadiday){
            for(int i=1; i<=loadtday;i++) {
                btn[i].setTextColor(Color.RED);
            }
            for(int i=loadtday+1; i<=loadiday;i++) {
                btn[i].setTextColor(Color.BLUE);
            }
        }

        else if(loadiday<=loadtday){
            for(int i=1; i<=loadiday;i++) {
                btn[i].setTextColor(Color.RED);
            }
            for(int i=loadiday+1; i<=loadtday;i++) {
                btn[i].setTextColor(Color.GREEN);
            }
        }

        Dday.setText("D - "+(100-toeicday));
    }

    //저장했던 이름 불러오기
    public int gettday(){
        SharedPreferences sf = getSharedPreferences(Name1,0);
        int tday = sf.getInt("tday",0);
        return tday;
    }

    //저장했던 이름 불러오기
    public int getiday(){
        SharedPreferences sf2 = getSharedPreferences(Name2,0);
        int iday = sf2.getInt("iday",0);
        return iday;
    }

    //이름 저장하기
    public void savePreferences() {
        SharedPreferences sf = getSharedPreferences(Name1, 0);
        SharedPreferences.Editor editor = sf.edit();
        editor.putInt("tday", toeicday);
        SharedPreferences sf2 = getSharedPreferences(Name2, 0);
        SharedPreferences.Editor editor2 = sf2.edit();
        editor2.putInt("iday", informday);

        editor.commit();editor2.commit();
    }

    //앱 종료시
    public void onStop() {
        super.onStop();
        savePreferences();
    }
}
