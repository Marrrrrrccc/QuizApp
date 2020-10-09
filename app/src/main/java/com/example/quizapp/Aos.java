package com.example.quizapp;

public class Aos {
    public String mQuestions[]={
            "When was UNIX developed?",
            "Which is not a variant of UNIX?",
            "UNIX Command to change directory?",
            "Enhanced Bourne Shell",
            "Base programming language of C shell?",
            "UNIX shortcut to close a program",
            "UNIX command for help?",
            "UNIX command to clear screen?",
            "DOS command to clear screen?",
            "UNIX command to make new directory?",
            "Where was UNIX developed? ",
            "Location for files in UNIX"
    };
    private String mChoices [][]= {
            {"1975", "1996", "1984", "1969"},
            {"Windows", "Xenix", "Linux", "Ultrix"},
            {"ls", "cd", "man", "cls"},
            {"C Shell", "J shell", "Rachel", "Korn Shell"},
            {"Java", "C++", "C", "C#"},
            {"ctrl + r", "ctrl + d", "alt +f4", "ctrl + c"},
            {"help", "?", "man", "cls" },
            {"clear", "cls", "cp", "cd"},
            {"clear", "cls", "cp", "cd"},
            {"md", "mkdr", "mkdir", "nd"},
            {"AT&T", "Apple", "Microsoft", "IBM"},
            {"Directory", "Folder", "File Explorer", "Tree"}


    };
    private String mCorrectAnswers[]=
            {"1969","Windows","cd","Korn Shell","C","ctrl + c","man","clear","cls","mkdir","AT&T","Directory"};
    public String title = "AOS";




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
