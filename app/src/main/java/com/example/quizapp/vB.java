package com.example.quizapp;

public class vB {
    public String mQuestions[]={
            "What is the three-character extension appended to solution filenames in Visual Basic?",
            "Statement that allows you to declare variables",
            "A(n) ____ is an environment that contains all of the tools and features you need to create, run, and test your programs.",
            "This property is important because it is needed primarily in calling the tool in coding.",
            "Format specifier to display the string with a dollar sign",
            "Which data type is appropriate for storing the name of a street?",
            "To display the words ABC company in a form’s title bar, you need to set which of the forms properties?",
            "What data type would this information be? (1 2 3 4 5 )",
            "Which of the following events occurs when a check box is clicked?",
            "If Harry wants to edit the BackColor, foreColor and visibility of the label, he must proceed to the ______",
            "A ______ variable is declared within a method",
            "Which statement terminates an application?"
    };
    private String mChoices [][]= {
            {"vbn", "sln", "jav", "txt"},
            {"var", "String", "Public", "dim"},
            {"Console", "IDE", "Compiler", "CLI"},
            {"Text", "Name", "Attribute", "Identifier"},
            {"C", "N", "F", "P"},
            {"Decimal", "Boolean", "Integer", "String"},
            {"Name", "Language", "Text", "Tag"},
            {"Boolean", "Char", "Integer", "Float"},
            {"OnClick", "TextChanged", "Leave", "CheckChanged"},
            {"Attribute", "Toolbox", "Event", "Property"},
            {"local", "block", "public", "modular"},
            {"Me.Close()", "Me.Terminate()", "Me.Focus()", "Me.CheckChanged()"}


    };
    private String mCorrectAnswers[]=
            {"sln","dim","IDE",
            "Name","C","String","Text","Integer",
            "CheckChanged","Property","local","Me.Close()"};
    public String title = "Visual Basic";


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
