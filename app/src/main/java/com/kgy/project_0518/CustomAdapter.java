package com.kgy.project_0518;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends PagerAdapter {
    Context context;
    ArrayList<String> word;
    ArrayList<String> fullname;
    ArrayList<String> define;
    ArrayList<String> freq;
    int day;




    CustomAdapter(Context context, ArrayList<String> text, ArrayList<String> text1, ArrayList<String> text2, ArrayList<String> text3, int day) {
        this.context = context;
        this.word = text;
        this.fullname = text1;
        this.define = text2;
        this.freq = text3;
        this.day = day;

    }

    @Override
    public int getCount() {
        return word.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.viewpager, container, false);
        final Button button  = (Button) layout.findViewById(R.id.btn);
        final TextView tv1  = (TextView) layout.findViewById(R.id.tv1);
        final TextView page_number = (TextView) layout.findViewById(R.id.page_number);
        final Button test_Button = (Button)layout.findViewById(R.id.test_btn);
        final TextView word_tv = (TextView)layout.findViewById(R.id.word);
        final TextView fullname_tv = (TextView)layout.findViewById(R.id.fullname);

       /* String word="";
        String mean="";
        String target1="(";
        String target2=")";



        int target_num1=text.get(position).indexOf(target1);
        int target_num2=text.get(position).indexOf(target2);
        if(target_num1>0 && target_num2>0) {
            mean = text.get(position).substring(target_num1 + 1, target_num2 );
            word = text.get(position).substring(0,target_num1-1);
            button.setText(word+"\n"+mean);

        }
        else
            word=text.get(position);
        button.setText(word);
        // String a= text.get(position).substring(target_num1,target_num2-1);
        //int b=text.get(position).length();
        int b=mean.length();
        Log.d("length",String.valueOf(word));
        Log.d("length",String.valueOf(mean));*/



        word_tv.setText(word.get(position));
        fullname_tv.setText(fullname.get(position));
        tv1.setText(freq.get(position));
        page_number.setText(position+1+"/5");
        button.setOnClickListener(new View.OnClickListener() {
            int count=0;
            @Override
            public void onClick(View view) {



                if (position == 0) {
                    if (count % 2 == 0) {
                        button.setText(define.get(position));
                        word_tv.setVisibility(view.GONE);
                        fullname_tv.setVisibility(view.GONE);
                        button.setTextSize(20);
                        word_tv.setTextSize(60);
                        button.setGravity(Gravity.CENTER_VERTICAL);
                        button.setPadding(50,0,50,0);
                        count++;
                    } else if (count % 2 == 1) {
                        word_tv.setVisibility(view.VISIBLE);
                        fullname_tv.setVisibility(view.VISIBLE);
                        button.setText("");
                        button.setGravity(Gravity.CENTER);
                        word_tv.setTextSize(60);
                        count++;
                    }

                }
                if (position == 1) {

                    if (count % 2 == 0) {
                        button.setText(define.get(position));
                        word_tv.setVisibility(view.GONE);
                        fullname_tv.setVisibility(view.GONE);
                        button.setTextSize(20);
                        word_tv.setTextSize(60);
                        button.setGravity(Gravity.CENTER_VERTICAL);
                        button.setPadding(50,0,50,0);
                        count++;
                    } else if (count % 2 == 1) {
                        word_tv.setVisibility(view.VISIBLE);
                        fullname_tv.setVisibility(view.VISIBLE);
                        button.setText("");
                        button.setGravity(Gravity.CENTER);
                        word_tv.setTextSize(60);
                        count++;
                    }

                }
                if (position == 2) {
                    if (count % 2 == 0) {
                        button.setText(define.get(position));
                        word_tv.setVisibility(view.GONE);
                        fullname_tv.setVisibility(view.GONE);
                        button.setTextSize(20);
                        word_tv.setTextSize(60);
                        button.setGravity(Gravity.CENTER_VERTICAL);
                        button.setPadding(50,0,50,0);
                        count++;
                    } else if (count % 2 == 1) {
                        word_tv.setVisibility(view.VISIBLE);
                        fullname_tv.setVisibility(view.VISIBLE);
                        button.setText("");
                        button.setGravity(Gravity.CENTER);
                        word_tv.setTextSize(60);
                        count++;
                    }

                }
                if (position == 3) {
                    if (count % 2 == 0) {
                        button.setText(define.get(position));
                        word_tv.setVisibility(view.GONE);
                        fullname_tv.setVisibility(view.GONE);
                        button.setTextSize(20);
                        word_tv.setTextSize(60);
                        button.setGravity(Gravity.CENTER_VERTICAL);
                        button.setPadding(50,0,50,0);
                        count++;
                    } else if (count % 2 == 1) {
                        word_tv.setVisibility(view.VISIBLE);
                        fullname_tv.setVisibility(view.VISIBLE);
                        button.setText("");
                        button.setGravity(Gravity.CENTER);
                        word_tv.setTextSize(60);
                        count++;
                    }

                }
                if (position == 4) {
                    test_Button.setVisibility(View.VISIBLE);
                    test_Button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent2 = new Intent(view.getContext(),InformTest.class);
                            intent2.putExtra("day",day);
                            intent2.putStringArrayListExtra("word",word);
                            intent2.putStringArrayListExtra("define",define);
                            view.getContext().startActivity(intent2);
                        }
                    });

                    if (count % 2 == 0) {
                        button.setText(define.get(position));
                        word_tv.setVisibility(view.GONE);
                        fullname_tv.setVisibility(view.GONE);
                        button.setTextSize(20);
                        word_tv.setTextSize(60);
                        button.setGravity(Gravity.CENTER_VERTICAL);
                        button.setPadding(50,0,50,0);
                        count++;
                    } else if (count % 2 == 1) {
                        word_tv.setVisibility(view.VISIBLE);
                        fullname_tv.setVisibility(view.VISIBLE);
                        button.setText("");
                        button.setGravity(Gravity.CENTER);
                        word_tv.setTextSize(60);
                        count++;
                    }

                }

            }

        });


        container.addView(layout, 0);

        return layout;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View)object;
    }


}





