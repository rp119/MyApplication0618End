package com.kgy.project_0518;

public class QuestionLibrary {
    private  String mQuestions [] = {
            "applicant",
            "requirement",
            "achievement",
            "position",
            "reference",
            "reference"
    };
    private  String mChoices [] [] = {
            {"   1.  관리자","   2.  지원자, 신청자","   3.  소비자"},
            {"   1.  불만","   2.  감사","   3.  필요조건, 요건"},
            {"   1.  성취, 달성","   2.  규범","   3.  승인"},
            {"   1.  방식, 태도" ,"   2.  특징, 특색","   3.  일자리, 직책"},
            {"   1.  추천서, 참고","   2.  사직서","   3.  이력서"},
            {"   1.  추천서, 참고","   2.  사직서","   3.  이력서"}
    };

    private String mCorrectAnswers [] = {
            "   2.  지원자, 신청자",
            "   3.  필요조건, 요건",
            "   1.  성취, 달성",
            "   3.  일자리, 직책",
            "   1.  추천서, 참고",
            "   1.  추천서, 참고"
    };

    public String getQuestion (int a) {
        String question = mQuestions[a];
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


}