package com.kgy.project_0518;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.ToIntBiFunction;
import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ToeicTest extends AppCompatActivity {
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private Button mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    int day;
    int count;
    static int problem_count = 0;
    int problem = 0;
    private String mAnswer;
    int mQuestionNumber = 0;
    static ArrayList<String> correct_word;
    static ArrayList<String> correct_mean;
    static String wrong_word;
    static String wrong_mean;
    static int random[];
    static Random r;

    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeictest);

        mQuestionView = (Button) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.answer1);
        mButtonChoice2 = (Button) findViewById(R.id.answer2);
        mButtonChoice3 = (Button) findViewById(R.id.answer3);
        TextView daytv = (TextView)findViewById(R.id.day);

        Intent intent1 = getIntent(); // 추가
        day = intent1.getIntExtra("day", 0);
        daytv.setText("DAY "+day);


        SharedPreferences sf = getSharedPreferences("toeic",0);
        number = sf.getInt("number",0);



        if (problem_count == 0) {
            ArrayList<String> word = intent1.getStringArrayListExtra("word");
            ArrayList<String> mean = intent1.getStringArrayListExtra("mean");
            Log.d("word", String.valueOf(word));
            Log.d("mean", String.valueOf(mean));
            Toast.makeText(getApplicationContext(), "선택한 day = " + day, Toast.LENGTH_SHORT).show(); // 추가


            correct_word = new ArrayList<String>(); //정답인 단어 배열
            correct_mean = new ArrayList<String>(); //문제 배열
            random = new int[6];
            r = new Random();

            for (int i = 0; i < 5; i++)    //숫자 5개를 뽑기위한 for문
            {
                random[i] = r.nextInt(5); //1~10숫자중 랜덤으로 하나를 뽑아 a[0]~a[5]에 저장
                for (int j = 0; j < i; j++) //중복제거를 위한 for문
                {
                    if (random[i] == random[j]) {
                        i--;
                    }
                }
            }
            for (int a = 0; a < 5; a++) {
                Log.d("random", String.valueOf(random[a]));
                correct_word.add(word.get(random[a])); //정답단어 추가
                Log.d("correct_word", String.valueOf(correct_word.get(a)));
                correct_mean.add(mean.get(random[a])); //문제 추가
                Log.d("correct_defind", String.valueOf(correct_mean.get(a)));
            }
        }


        final String sequence[] = new String[3];
        problem = problem_count;
        //문제를 섞기위한 조건문

        int s[] = new int[2];
        for (int i = 0; i < 2; i++) {
            s[i] = r.nextInt(5); //1~10숫자중 랜덤으로 하나를 뽑아 s[0]~s[5]에 저장
            for (int j = 0; j < i; j++) //중복제거를 위한 for문
            {
                if (s[i] == s[j])
                    i--;
            }
            if (s[i] == problem) //
                i--;
        }

        for (int c = 0; c < 2; c++)
            Log.d("s", String.valueOf(s[c]));

        sequence[0] = correct_word.get(problem);
        sequence[1] = correct_word.get(s[0]);
        sequence[2] = correct_word.get(s[1]);

        final String correct = correct_word.get(problem);

        Log.d("sq0", sequence[0]);
        Log.d("sq1", sequence[1]);
        Log.d("sq2", sequence[2]);


        final int a[] = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = r.nextInt(3); //1~10숫자중 랜덤으로 하나를 뽑아 a[0]~a[5]에 저장
            for (int j = 0; j < i; j++) //중복제거를 위한 for문
            {
                if (a[i] == a[j])
                    i--;
            }
        }

        for (int c = 0; c < 3; c++)
            Log.d("a", String.valueOf(a[c]));

        mQuestionView.setText(correct_mean.get(problem));
        mButtonChoice1.setText(sequence[a[0]]);
        mButtonChoice2.setText(sequence[a[1]]);
        mButtonChoice3.setText(sequence[a[2]]);

        problem_count++;
        Log.d("problem_count", String.valueOf(problem_count));
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (correct == mButtonChoice1.getText() ) {
                    Toast.makeText(ToeicTest.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ToeicTest.this, "틀렸습니다!", Toast.LENGTH_SHORT).show();
                    wrong_word = correct;
                    Log.d("wrong", String.valueOf(wrong_word));

                    SharedPreferences sf = getSharedPreferences("toeic", 0);
                    SharedPreferences.Editor editor = sf.edit();
                    number++;
                    editor.putInt("number", number);
                    editor.putString("tspell"+number, correct);
                    editor.putString("tmean"+number, correct_mean.get(problem));

                    editor.commit();
                }
                if(problem_count>=5){
                    problem_count=0;
                    Intent intent = new Intent(getApplicationContext(),AttendanceActivity.class);
                    intent.putExtra("Day",day);
                    intent.putExtra("Subject",1);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(), ToeicTest.class);
                    intent2.putExtra("day",day);
                    startActivity(intent2);
                    finish();
                }
            }

        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (correct == mButtonChoice2.getText()) {
                    Toast.makeText(ToeicTest.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ToeicTest.this, "틀렸습니다!", Toast.LENGTH_SHORT).show();
                    wrong_word = correct;
                    Log.d("wrong", String.valueOf(wrong_word));

                    SharedPreferences sf = getSharedPreferences("toeic", 0);
                    SharedPreferences.Editor editor = sf.edit();
                    number++;
                    editor.putInt("number", number);
                    editor.putString("tspell"+number, correct);
                    editor.putString("tmean"+number, correct_mean.get(problem));

                    editor.commit();

                }
                if(problem_count>=5){
                    problem_count=0;
                    Intent intent = new Intent(getApplicationContext(),AttendanceActivity.class);
                    intent.putExtra("Day",day);
                    intent.putExtra("Subject",1);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(), ToeicTest.class);
                    intent2.putExtra("day",day);
                    startActivity(intent2);
                    finish();
                }
            }

        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (correct == mButtonChoice3.getText()) { //sequence[a[2]]
                    Toast.makeText(ToeicTest.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ToeicTest.this, "틀렸습니다!", Toast.LENGTH_SHORT).show();
                    wrong_word = correct;
                    Log.d("wrong", String.valueOf(wrong_word));

                    SharedPreferences sf = getSharedPreferences("toeic", 0);
                    SharedPreferences.Editor editor = sf.edit();
                    number++;
                    editor.putInt("number", number);
                    editor.putString("tspell"+number, correct);
                    editor.putString("tmean"+number, correct_mean.get(problem));

                    editor.commit();
                }
                if(problem_count>=5){
                    problem_count=0;
                    Intent intent = new Intent(getApplicationContext(),AttendanceActivity.class);
                    intent.putExtra("Day",day);
                    intent.putExtra("Subject",1);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(), ToeicTest.class);
                    intent2.putExtra("day",day);
                    startActivity(intent2);
                    finish();
                }
            }

        });


    }
}



