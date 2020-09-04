package com.kgy.project_0518;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import static android.speech.tts.TextToSpeech.ERROR;

public class ToeicActivity extends AppCompatActivity {

    ArrayList<String> word;
    ArrayList<String> mean;
    ArrayList<String> speech;
    ArrayList<String> symbol;
    ArrayList<String> image;


    private TextToSpeech tts;              // TTS 변수 선언
    private TextView textView, textView2, textView3, textView4;
    private Button button1, button2, button3, button4, button5;
    private ImageView imageView;
    int count=0;
    int img [] =new int[5];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeic);

        textView = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        imageView = (ImageView) findViewById(R.id.image1);
        button1 = (Button) findViewById(R.id.button01);
        button2 = (Button) findViewById(R.id.button02);
        button3 = (Button) findViewById(R.id.button03);
        button4 = (Button) findViewById(R.id.button04);
        button5 = (Button) findViewById(R.id.button05);
        imageView.setBackgroundResource(R.drawable.applicant);

        final Intent intent = getIntent(); // 추가
        final int day = intent.getIntExtra("day",0); // 스크롤 Activity에서 day 값을 전달받는다 ex(day 1 을 선택하면 0, day 2 를 선택하면 1)
        Toast.makeText(getApplicationContext(),"선택한 day = " + day, Toast.LENGTH_SHORT).show(); // 추가
        textView.setText("Day "+day);
        Log.d("day",String.valueOf(day));
        try {
            InputStream is = getBaseContext().getResources().getAssets().open("list_toiec.xls");
            Workbook wb = Workbook.getWorkbook(is);

            if(wb != null) {
                Sheet sheet = wb.getSheet(0);   // 시트 불러오기 (0은 첫번째 시트를 말함)
                if(sheet != null) {
                    int colTotal = sheet.getColumns();    // 전체 컬럼
                    int rowIndexStart = 1;                  // row 인덱스 시작
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
                    mean = new ArrayList<String>();
                    speech = new ArrayList<String>();
                    symbol = new ArrayList<String>();
                    image=new ArrayList<String>();
                    String packageName = this.getPackageName();
                    ;

                    for(int i=0; i<5; i++) //5개의 단어와 빈출연도를 배열에 저장
                    {
                        word.add(sheet.getCell(0,(5*day-4)+i).getContents());
                        mean.add(sheet.getCell(1,(5*day-4)+i).getContents());
                        symbol.add(sheet.getCell(2,(5*day-4)+i).getContents());
                        speech.add(sheet.getCell(3,(5*day-4)+i).getContents());
                        image.add("@drawable/"+word.get(i));
                        img[i]=getResources().getIdentifier(image.get(i),"drawable",packageName);
                    }
                    Log.d("word", String.valueOf(word));
                    Log.d("mean", String.valueOf(mean));
                    Log.d("symbol", String.valueOf(symbol));
                    Log.d("speech", String.valueOf(speech));
                    Log.d("img", String.valueOf(img));

                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (BiffException e) {
            e.printStackTrace();
        }
        textView2.setText(word.get(0));
        textView3.setText(symbol.get(0));
        textView4.setText(mean.get(0));
        imageView.setBackgroundResource(img[0]);

        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                count++;
                if (count == 1) {
                    textView2.setText(word.get(1));
                    textView3.setText(symbol.get(1));
                    textView4.setText(mean.get(1));
                    imageView.setBackgroundResource(img[1]);
                }
                if (count == 2) {
                    textView2.setText(word.get(2));
                    textView3.setText(symbol.get(2));
                    textView4.setText(mean.get(2));
                    imageView.setBackgroundResource(img[2]);
                }
                if (count == 3) {
                    textView2.setText(word.get(3));
                    textView3.setText(symbol.get(3));
                    textView4.setText(mean.get(3));
                    imageView.setBackgroundResource(img[3]);
                }
                if (count == 4) {
                    textView2.setText(word.get(4));
                    textView3.setText(symbol.get(4));
                    textView4.setText(mean.get(4));
                    imageView.setBackgroundResource(img[4]);
                    button4.setVisibility(View.VISIBLE);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count -1;
                if (count == 0) {
                    textView2.setText(word.get(0));
                    textView3.setText(symbol.get(0));
                    textView4.setText(mean.get(0));
                    imageView.setBackgroundResource(img[0]);
                }
                if (count == 1) {
                    textView2.setText(word.get(1));
                    textView3.setText(symbol.get(1));
                    textView4.setText(mean.get(1));
                    imageView.setBackgroundResource(img[1]);
                }
                if (count == 2) {
                    textView2.setText(word.get(2));
                    textView3.setText(symbol.get(2));
                    textView4.setText(mean.get(2));
                    imageView.setBackgroundResource(img[2]);
                }
                if (count == 3) {
                    textView2.setText(word.get(3));
                    textView3.setText(symbol.get(3));
                    textView4.setText(mean.get(3));
                    imageView.setBackgroundResource(img[3]);
                }
                if (count == 4) {
                    textView2.setText(word.get(4));
                    textView3.setText(symbol.get(4));
                    textView4.setText(mean.get(4));
                    imageView.setBackgroundResource(img[4]);
                    button4.setVisibility(View.VISIBLE);

                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ToeicTest.class);
                intent.putExtra("day",day);
                intent.putStringArrayListExtra("word",word);
                intent.putStringArrayListExtra("mean",mean);
                v.getContext().startActivity(intent);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // TTS를 생성하고 OnInitListener로 초기화 한다.
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR) {
                    // 언어를 선택한다.
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(textView2.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
            }
        }); }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TTS 객체가 남아있다면 실행을 중지하고 메모리에서 제거한다.
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null; }
    }
}
