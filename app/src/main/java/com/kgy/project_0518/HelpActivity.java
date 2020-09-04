package com.kgy.project_0518;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HelpActivity extends AppCompatActivity {
    private RelativeLayout mlayoutColor;
    ImageView helpimg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpactivity);
        mlayoutColor = (RelativeLayout)findViewById(R.id.layout);
        helpimg = (ImageView)findViewById(R.id.helpimg);
        final Button nextbtn = (Button)findViewById(R.id.NextBtn);


        nextbtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View view) {
                if (count == 0) {
                    mlayoutColor.setBackgroundResource(R.color.helpimg2);
                    helpimg.setImageResource(R.drawable.helpimg2);
                    nextbtn.setBackgroundResource(R.color.help_background2);
                    count++;

                }
                else if(count==1){
                    mlayoutColor.setBackgroundResource(R.color.helpimg3);
                    helpimg.setImageResource(R.drawable.helpimg3);
                    nextbtn.setBackgroundResource(R.color.help_background3);
                    count++;
                    nextbtn.setText("START");

                }
                else if(count==2){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }

        });


    }
}
