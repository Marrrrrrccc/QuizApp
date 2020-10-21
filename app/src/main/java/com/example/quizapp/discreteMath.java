package com.example.quizapp;

public class discreteMath {
    public String mQuestions[]={
            "__________ are used to form compound propositions",
            "Conclusions logically follow from truth of hypotheses.",
            "The members of the set",
            "The branch of mathematics that is concerned with the integers and their properties",
            "Connects a pair of vertices",
            "Used to visualize relationships of sets",
            "An unordered collection of objects",
            "An invalid argument",
            "Statement shown to be true; Facts",
            "Statement assumed to be true; Postulates, Laws",
            "Preliminary theorem; Propositions",
            "A sequence of statements that end with conclusions"
    };
    private String mChoices [][]= {
            {"Operators", "Logic", "Condition", "Contract"},
            {"Argument", "Valid argument", "Proof", "Theorem"},
            {"Attributes", "Properties", "Elements", "Set List"},
            {"Number Theory", "Applied Math", "Calculus", "Discrete Math"},
            {"Vertex", "Edge", "Node", "Root"},
            {"Graphs", "Logic Diagram", "Preset", "Venn Diagram"},
            {"Diagram", "Relation", "Sets", "Trees"},
            {"Proof", "Fallacy", "Theorem", "Logic"},
            {"Argument", "Valid argument", "Proof", "Theorem"},
            {"Axiom", "Corollary", "Theorem", "Fallacy"},
            {"Lemma", "Corollary", "Theorem", "Fallacy"},
            {"Argument", "Valid argument", "Proof", "Theorem"}


    };
    private String mCorrectAnswers[]=
            {"Operators","Valid argument","Elements",
            "Number Theory","Edge","Venn Diagram","Sets","Fallacy",
            "Theorem","Axiom","Lemma","Argument"};

    public String title = "Discrete Math";




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
