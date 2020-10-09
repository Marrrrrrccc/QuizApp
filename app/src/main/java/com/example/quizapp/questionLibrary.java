package com.example.quizapp;

public class questionLibrary {
    public String mQuestions[]={
            "What is the most famous programming language?",
            "Who invented microsoft?",
            "Who invented world wide web (www)?",
            "Which is used for backend programming?",
            "The 'H' in HTML Stands for",
            "Programming Language used in Adroid Studio besides Java?",
            "What is used for conditional statements?",
            "How many data types in java?",
            "Phone brand that uses IOS",
            "What data type is used for true or false?",
            "Data type commonly used for decimals in JAVA?",
            "2nd most famous programming language?"
    };
    private String mChoices [][]= {
            {"Java", "C", "VB.NET", "Javascript"},
            {"tim berners-lee" , "bill gates" , "linus tech" , "steve jobs"},
            {"steve jobs" , "tim berners-lee" , "linus tech" , "bill gates "},
            {"C++", "Java", "MySQL", "HTML"},
            {"Hypertext", "Hyperlink", "Hayward", "Home"},
            {"Kotlin", "Ruby", "C#", "None of the Above"},
            {"if-else", "for", "do-while", "array"},
            {"5", "8", "6", "7"},
            {"huawei" , "samsung" , "vivo" , "iphone"},
            {"int", "char", "boolean", "double"},
            {"int", "boolean", "char", "double"},
            {"C++", "C", "Php", "Java"}


    };
    private String mCorrectAnswers[]=
            {"C","bill gates","tim berners-lee","MySQL","Hypertext","Kotlin","if-else","8","iphone","boolean","double","Java"};
    public String title = "Programming";




    public String getmQuestions(int a) {
        String questions = mQuestions[a];
        return questions;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }
    public String getCorrectAnswer (int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
