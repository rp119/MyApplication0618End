package com.kgy.project_0518;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class QuestionLibrary2{
    ArrayList<String> word;
    ArrayList<String> define;}
/*
    try
    {
        InputStream is = getBaseContext().getResources().getAssets().open("list_information.xls");
        Workbook wb = Workbook.getWorkbook(is);

        if (wb != null) {
            Sheet sheet = wb.getSheet(0);   // 시트 불러오기 (0은 첫번째 시트를 말함)
            if (sheet != null) {
                int colTotal = sheet.getColumns();    // 전체 컬럼
                int rowIndexStart = 1;                  // row 인덱스 시작
                int rowTotal = sheet.getColumn(colTotal - 1).length;
                Log.d("col", String.valueOf(colTotal));
                Log.d("row", String.valueOf(rowTotal));


                word = new ArrayList<String>();
                define = new ArrayList<String>();


                for (int i = 0; i < 5; i++) //5개의 단어와 빈출연도를 배열에 저장
                {

                    word.add(sheet.getCell(1, (5 * day - 4) + i).getContents());
                    Log.d("word", String.valueOf(word));
                    define.add(sheet.getCell(2, (5 * day - 4) + i).getContents());
                    Log.d("define", String.valueOf(define));

                }
            }
        }

        catch(IOException e){
        e.printStackTrace();
    }
        catch(BiffException e){
        e.printStackTrace();
    }



    /*private  String mQuestions [] = { //define
            "준비 큐로부터 대기 프로세스를 골라서 CPU를 할당하는 작업이다.\n선택된 프로세스는 디스패처에 의해 CPU가 할당된다.",
            "데이터베이스로부터 정보를 저장하고 수정하며 추출하도록 해주는 프로그램의 집합이다.",
            "사용자가 웹사이트를 검색하는 동안 해당 웹사이트로부터 보내진다. \n그 후 사용자의 웹 브라우저 안에 저장되는 작은 데이터 조각을 말한다.",
            "비교적 제한된 영역 안에 분산되어 있는 컴퓨터와 다른 장치들의 그룹이다. 통신 링크에 의해 연결되어 네트워크 안에 장치들끼리 상호 작용할 수 있다.",
            "회사가 현재의 고객과 잠재적 고객과의 접촉을 추적하고 구성하는데 사용한 절차들로 구성되어있다.",
            "회사가 현재의 고객과 잠재적 고객과의 접촉을 추적하고 구성하는데 사용한 절차들로 구성되어있다."
    };
    private  String mChoices [] [] = {
            {"DBMS\n" + "(Database management system)","LAN\n"+ "(Local Area Network)","CPU Scheduling"},
            {"LAN\n"+ "(Local Area Network)","Cookie","DBMS\n" + "(Database management system)"},
            {"CPU Scheduling","CRM\n(Customer Relationship ManageMent)","Cookie"},
            {"DBMS\n" + "(Database management system)","LAN\n"+ "(Local Area Network)","CPU Scheduling"},
            {"Cookie","CPU Scheduling","CRM\n(Customer Relationship ManageMent)"},
            {"Cookie","CPU Scheduling","CRM\n(Customer Relationship ManageMent)"}
    };

    private String mCorrectAnswers [] = { word 랜덤으로
            "CPU Scheduling",
            "DBMS\n" + "(Database management system)",
            "Cookie",
            "LAN\n"+ "(Local Area Network)",
            "CRM\n(Customer\nRelationship\nManageMent)",
            "CRM\n(Customer\nRelationship\nManageMent)"
    };*/

/*
    public String getQuestion (int a) {
        String question = mQuestions [a];
        return question;
    }
    public String getChoice1 (int a) {
        String choice0 = mChoices [a] [0];
        return choice0;
    }
    public String getChoice2 (int a) {
        String choice1 = mChoices [a] [1];
        return choice1;
    }
    public String getChoice3 (int a) {
        String choice2 = mChoices [a] [2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers [a];
        return answer;
    }


}*/
