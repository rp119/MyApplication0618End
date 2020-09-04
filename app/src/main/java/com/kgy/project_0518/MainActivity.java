package com.kgy.project_0518;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton toiecbtn = null;
    ImageButton infobtn = null;
    ImageButton odapbtn = null;
    ImageButton settingbtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toiecbtn = (ImageButton)findViewById(R.id.toiecbtn);
        infobtn = (ImageButton)findViewById(R.id.infobtn);
        odapbtn = (ImageButton)findViewById(R.id.odapbtn);
        settingbtn = (ImageButton)findViewById(R.id.settingbtn);


        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InformationScrollActivity.class);
                startActivity(intent);
            }
        });
        toiecbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ToeicScrollActivity.class);
                startActivity(intent);
            }
        });
        odapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OdabtoeicActivity.class);
                startActivity(intent);
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlramActivity.class);
                startActivity(intent);
            }
        });

}
}
