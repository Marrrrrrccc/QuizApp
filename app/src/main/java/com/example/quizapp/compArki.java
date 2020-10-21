package com.example.quizapp;

public class compArki {
    public String mQuestions[]={
            "What are the basic building blocks of digital circuits?",
            "Which is not a basic logical operation?",
            "When was K-Map developed?",
            "K-map that uses 2x4 table",
            "Symbol for don't care condition",
            "What are sequential logic circuits that go through a prescribed sequence of states upon application of count pulses?",
            "It refers to circuits whose output is strictly dependent on the present value of the inputs.",
            "Circuit whose outputs depend not only on the present input value but also the past input value",
            "What is the 3rd step in analyzing a sequential circuit?",
            "What is the 3rd step in designing a sequential circuit?",
            "A special program that translates assembly language into machine language",
            "A special program that translates high-level language into machine language"
    };
    private String mChoices [][]= {
            {"Logic gates", "Circuits", "Boolean Algebra", "Logic Operations"},
            {"And", "Or", "Not", "Nor"},
            {"1970", "1987", "1959", "1953"},
            {"2-variable", "3-variable", "4-variable", "5-variable"},
            {"X", "Σ", "'", "Π"},
            {"Counters", "Sequence", "Deadlocks", "K-map"},
            {"Combinational Logic Circuit", "Sequential Circuit", "Integrated Circuit", "Logic Circuits"},
            {"Combinational Logic Circuit", "Sequential Circuit", "Integrated Circuit", "Logic Circuits"},
            {"Transition table", "State Diagram", "Excitation Table", "Boolean Expression"},
            {"Trasition table", "State Diagram", "Excitation Table", "Boolean Expression"},
            {"IDE", "Console", "Compiler", "Assembler"},
            {"IDE", "Console", "Compiler", "Assembler"}


    };
    private String mCorrectAnswers[]=
            {"Logic gates","Nor","1953",
            "3-variable","X","Counters","Combinational Logic Circuit","Sequential Circuit",
            "Transition table","Boolean Expression","Assembler","Compiler"};
    public String title = "Computer Architecture";

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