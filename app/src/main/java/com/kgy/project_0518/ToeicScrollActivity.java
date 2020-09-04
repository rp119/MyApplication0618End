package com.kgy.project_0518;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToeicScrollActivity extends AppCompatActivity {

    String Name1="file1";

    int day;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeicscroll);

        final Button btn[] = new Button[100];
        final Integer btnId[] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10
                , R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20
                , R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25, R.id.btn26, R.id.btn27, R.id.btn28, R.id.btn29, R.id.btn30
                , R.id.btn31, R.id.btn32, R.id.btn33, R.id.btn34, R.id.btn35, R.id.btn36, R.id.btn37, R.id.btn38, R.id.btn39, R.id.btn40
                , R.id.btn41, R.id.btn42, R.id.btn43, R.id.btn44, R.id.btn45, R.id.btn46, R.id.btn47, R.id.btn48, R.id.btn49, R.id.btn50
                , R.id.btn51, R.id.btn52, R.id.btn53, R.id.btn54, R.id.btn55, R.id.btn56, R.id.btn57, R.id.btn58, R.id.btn59, R.id.btn60
                , R.id.btn61, R.id.btn62, R.id.btn63, R.id.btn64, R.id.btn65, R.id.btn66, R.id.btn67, R.id.btn68, R.id.btn69, R.id.btn70
                , R.id.btn71, R.id.btn72, R.id.btn73, R.id.btn74, R.id.btn75, R.id.btn76, R.id.btn77, R.id.btn78, R.id.btn79, R.id.btn80
                , R.id.btn81, R.id.btn82, R.id.btn83, R.id.btn84, R.id.btn85, R.id.btn86, R.id.btn87, R.id.btn88, R.id.btn89, R.id.btn90
                , R.id.btn91, R.id.btn92, R.id.btn93, R.id.btn94, R.id.btn95, R.id.btn96, R.id.btn97, R.id.btn98, R.id.btn99, R.id.btn100};

        int store = getPreferences();
        day = store;

        for(int i = 0; i<btnId.length; i++) {

            final int index;
            index = i;
            btn[index] = findViewById(btnId[index]);
            if(i<=store)
                btn[i].setEnabled(true);
        }

        for(int i = 0; i<btnId.length; i++) {
            final int finalI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),ToeicActivity.class);
                    intent.putExtra("day", finalI +1);
                    startActivity(intent);
                }
            });
        }
    }

    //저장했던 이름 불러오기
    public int getPreferences(){
        SharedPreferences sf = getSharedPreferences(Name1,0);
        int a = sf.getInt("tday",0);
        return a;
    }
}
