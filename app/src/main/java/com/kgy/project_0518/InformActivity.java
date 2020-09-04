package com.kgy.project_0518;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class InformActivity extends AppCompatActivity {
    ViewPager viewpager;
    ArrayList<String> word;
    ArrayList<String> fullname;
    ArrayList<String> define;
    ArrayList<String> freq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_study);

        final Intent intent = getIntent(); // 추가
        final int day = intent.getIntExtra("day",0); // 스크롤 Activity에서 day 값을 전달받는다 ex(day 1 을 선택하면 0, day 2 를 선택하면 1)
        Toast.makeText(getApplicationContext(),"선택한 day = " + day, Toast.LENGTH_SHORT).show(); // 추가
        TextView dayTv = (TextView)findViewById(R.id.day);
        dayTv.setText("Day "+day);
        Log.d("day",String.valueOf(day));
        try {
            InputStream is = getBaseContext().getResources().getAssets().open("list_information.xls");
            Workbook wb = Workbook.getWorkbook(is);

            if(wb != null) {
                Sheet sheet = wb.getSheet(0);   // 시트 불러오기 (0은 첫번째 시트를 말함)
                if(sheet != null) {
                    int colTotal = sheet.getColumns();    // 전체 컬럼
                    int rowIndexStart =1;                  // row 인덱스 시작
                    int rowTotal = sheet.getColumn(colTotal-1).length;
                    Log.d("col",String.valueOf(colTotal));
                    Log.d("row",String.valueOf(rowTotal));
/*
                    StringBuilder sb;
                    for(int row=rowIndexStart;row<6;row++) {
                        sb = new StringBuilder();
                        for(int col=0;col<colTotal;col++) {
                            String contents = sheet.getCell(col, row).getContents();
                            sb.append("col"+col+" : "+contents+" , ");
                            tv.append("col"+col+" : "+contents+" \n ");
                        }
                        Log.i("test", sb.toString());
                    }*/
                    word = new ArrayList<String>();
                    fullname = new ArrayList<String>();
                    define = new ArrayList<String>();
                    freq = new ArrayList<String>();


                    for(int i=0; i<5; i++) //5개의 단어와 빈출연도를 배열에 저장
                    {

                        word.add(sheet.getCell(1,(5*day-4)+i).getContents());
                        Log.d("word", String.valueOf(word));
                        fullname.add(sheet.getCell(2,(5*day-4)+i).getContents());
                        Log.d("fullname", String.valueOf(fullname));
                        define.add(sheet.getCell(3,(5*day-4)+i).getContents());
                        Log.d("define", String.valueOf(define));
                        freq.add(sheet.getCell(4,(5*day-4)+i).getContents());
                        Log.d("freq", String.valueOf(freq));

                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (BiffException e) {
            e.printStackTrace();
        }


        viewpager = (ViewPager) findViewById(R.id.pager);
        final Button button = (Button) findViewById(R.id.btn);


        CustomAdapter mPagerAdapter = new CustomAdapter(this, word,fullname,define,freq,day);
        viewpager.setAdapter(mPagerAdapter);
    }

}
