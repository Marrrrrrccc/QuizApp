package com.example.quizapp;

public class and {
    public String mQuestions[]={
            "Which of the following is not a valid Android resource file name?",
            "What is the parent class of all Activity widgets?",
            "During an Activity life-cycle, what is the first callback method invoked by the system?",
            "Which of these files contains text values that you can use in your application?",
            "What does the src folder contain?",
            "Which of the following is a java call-back method invoked when a view is clicked?",
            "It runs in the background for an indefinite period of time.",
            "It is a control that contain light indicator which can be turned to either on or off.",
            "It is called when the activity starts interacting with the user.",
            "It is a component of an application that used to store and receive data and make it accessible to all applications.",
            "It is a control that is used for displaying text for the users.",
            "It is an open mobile phone platform that was developed by Google."
    };
    private String mChoices [][]= {
            {"myLayout.xml", "my_layout.xml", "mylayout.xml", "mylayout1.xml"},
            {"ViewGroup", "Layout", "Widget", "View"},
            {"onRestore()", "onStop()", "onStart()", "onCreate()"},
            {"res/layout/Main.xml", "res/Text.xml", "res/values/Strings.xml", "AndroidManifest.xml"},
            {"The application manifest file", "Java source code files", "Image and icon files", "XML resource files"},
            {"OnTapListener", "Detector", "OnClickDetector", "OnClickListener"},
            {"Services", "Broadcast receivers", "Content providers", "Activities"},
            {"ImageButton", "ToggleButton", "CheckBox", "Button"},
            {"onResume()", "onCreate()", "onPause()", "onStart()"},
            {"Services", "Content providers", "Broadcast receivers", "Activities"},
            {"RadioButton", "Button", "EditText", "TextView"},
            {"Android", "IOS", "Google", "Safari"}


    };
    private String mCorrectAnswers[]=
            {"myLayout.xml","View","onCreate()",
            "res/values/Strings.xml","Java source code files","OnClickListener","Services","ToggleButton",
            "onResume()","Content providers","TextView","Android"};

    public String title = "Android Studio";




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
