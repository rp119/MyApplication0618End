package com.kgy.project_0518;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;

public class OdabtoeicActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odabtoeic);

        EditText spell[] = new EditText[20];
        Integer spellId[] = {R.id.spell1,R.id.spell2,R.id.spell3,R.id.spell4,R.id.spell5,R.id.spell6,R.id.spell7,R.id.spell8,R.id.spell9,R.id.spell10,
                R.id.spell11,R.id.spell12,R.id.spell13,R.id.spell14,R.id.spell15,R.id.spell16,R.id.spell17,R.id.spell18,R.id.spell19,R.id.spell20};

        for(int i = 0; i<spellId.length; i++) {
            final int index;
            index = i;
            spell[index] = findViewById(spellId[index]);
        }

        EditText mean[] = new EditText[20];
        Integer meanId[] = {R.id.mean1,R.id.mean2,R.id.mean3,R.id.mean4,R.id.mean5,R.id.mean6,R.id.mean7,R.id.mean8,R.id.mean9,R.id.mean10,
                R.id.mean11,R.id.mean12,R.id.mean13,R.id.mean14,R.id.mean15,R.id.mean16,R.id.mean17,R.id.mean18,R.id.mean19,R.id.mean20};
        for(int i = 0; i<meanId.length; i++) {
            final int index;
            index = i;
            mean[index] = findViewById(meanId[index]);
        }

        SharedPreferences sf = getSharedPreferences("toeic",0);
        int number = sf.getInt("number",0);

        for(int i=0; i<=number; i++){
            spell[i].setVisibility(View.VISIBLE);
            mean[i].setVisibility(View.VISIBLE);
            String a = sf.getString("tspell"+i,"");
            String b = sf.getString("tmean"+i,"");
            spell[i].setText(a);
            mean[i].setText(b);
        }
     }
}