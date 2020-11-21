package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class insideQuiz extends AppCompatActivity {
    private static String FILE_NAME;
    private TextView mScoreView;
    private TextView mQuestionView;
    private TextView qNumber;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonSave;
    private TextView mExamTitle;
    private String file;
    private DatabaseHelper mydb = new DatabaseHelper(this);
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String toast;
    private Button mButtonNext;
    private CardView cardView;
    private String quiz;
    private String[] questions;
    private String[] choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity m = new MainActivity();
        //removes notification bar and makes the app full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_inside_quiz);

        Button backButton = (Button) findViewById(R.id.backButton);
        mExamTitle = findViewById(R.id.ExamTitle);
        cardView = findViewById(R.id.question);
        mQuestionView = findViewById(R.id.questions);
        qNumber = findViewById(R.id.qNumber);
        mButtonChoice1 = findViewById(R.id.addChoice1);
        mButtonChoice2 = findViewById(R.id.addChoice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);
        mButtonNext = findViewById(R.id.next);
        quiz = String.valueOf(getIntent().getStringExtra("quiz"));
        updateQuestion();
        //adds button onclick listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHomescreen();
            }
        });
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic starts here
                if (mButtonChoice1.getText().equals(mAnswer)) {
                    mButtonChoice1.setBackgroundColor(Color.GREEN);
//                    mScore++;
                } else {
                    mButtonChoice1.setBackgroundColor(Color.RED);
                }

            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                //logic starts here
                if (mButtonChoice2.getText().equals(mAnswer)) {
                    mButtonChoice2.setBackgroundColor(Color.GREEN);
//                    mScore++;
                } else {
                    mButtonChoice2.setBackgroundColor(Color.RED);
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                //logic starts here
                if (mButtonChoice3.getText().equals(mAnswer)) {
                    mButtonChoice3.setBackgroundColor(Color.GREEN);
//                    mScore++;
                } else {
                    mButtonChoice3.setBackgroundColor(Color.RED);
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                //logic starts here
                if (mButtonChoice4.getText().equals(mAnswer)) {
                    mButtonChoice4.setBackgroundColor(Color.GREEN);
//                    mScore++;
                } else {
                    mButtonChoice4.setBackgroundColor(Color.RED);
                }
            }
        });
        //method to go to the next questions
        mButtonNext.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("ResourceAsColor")
            public void onClick(View view){
                //slideUp(mButtonChoice1);//sets the animations
                //slideUp(mButtonChoice2);
                //slideUp(mButtonChoice3);
                //slideUp(mButtonChoice4);
                swipe(cardView);
                save(view,FILE_NAME);
                //slideLeft(cardView);
                mButtonChoice1.setBackgroundColor(Color.TRANSPARENT);//brings back the color of each button
                mButtonChoice2.setBackgroundColor(Color.TRANSPARENT);//brings back the color of each button
                mButtonChoice3.setBackgroundColor(Color.TRANSPARENT);//brings back the color of each button
                mButtonChoice4.setBackgroundColor(Color.TRANSPARENT);//brings back the color of each button

                updateQuestion();


            }
        });
    }
        //method for going back to the homescreen
        public void toHomescreen () {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); //animation for transitioning back to the homescreen
        }

        @Override
        public void finish() { //same animation transition going back to homescreen using back button
            super.finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }

        //method the updates the question
        private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }
        //method to set the animations

        private void swipe (View v){
            Animation swipe = AnimationUtils.loadAnimation(insideQuiz.this, R.anim.swipe);
            v.setAnimation(swipe);
        }


        //method that save the question to a text file

    public void save(View v,String name) {
        String question = "Question:" + mQuestionView.getText().toString();
        String choice1 = "Choice1:" + mButtonChoice1.getText().toString();
        String choice2 = "Choice2:" + mButtonChoice2.getText().toString();
        String choice3 = "Choice3:" + mButtonChoice3.getText().toString();
        String choice4 = "Choice4:" + mButtonChoice4.getText().toString();
        String correctAnswer = "correct answer:" +mAnswer;
        File file = new File(getFilesDir() + "/" + name); //path where it is save
        String lineSeparator = System.getProperty("line.separator"); //new line
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
            fos = openFileOutput(name, MODE_APPEND);
            fos.write(question.getBytes());//display the questions
            fos.write(lineSeparator.getBytes());//creates a new line
            fos.write(choice1.getBytes());//display the choices
            fos.write(lineSeparator.getBytes());
            fos.write(choice2.getBytes());
            fos.write(lineSeparator.getBytes());
            fos.write(choice3.getBytes());
            fos.write(lineSeparator.getBytes());
            fos.write(choice4.getBytes());
            fos.write(lineSeparator.getBytes());
            fos.write(correctAnswer.getBytes());
            fos.write(lineSeparator.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updateQuestion(){
        switch (quiz){
            case "programming"://pagka "programming" "quiz" yung pinindot
                FILE_NAME = "programming.txt";//set the name of the file

                getQuestion("10","Programming");
                break;
            case "Aos":
               FILE_NAME = "Aos.txt";
                getQuestion("2","AOS");

                break;
            case "FRONT-END":
               FILE_NAME = "front-end.txt";

                getQuestion("7","Front-end");
                break;
            case "DATA ALGO":
                FILE_NAME = "Data-Algo.txt";

                getQuestion("4","Data Algo");
                break;
            case "OS":
                FILE_NAME = "operating system.txt";
                getQuestion("9","OS");
                break;
            case "DM":
             FILE_NAME= "Discrete.txt";

                getQuestion("3", "Discrete Math");
                break;
            case "ETHICS":
                FILE_NAME= "Ethics.txt";

                getQuestion("6","Ethics");
                break;
            case "VB":
                FILE_NAME= "Visual-basic.txt";

                getQuestion("11","VB");
                break;
            case "HCI":
                FILE_NAME= "HCI.txt";

                getQuestion("8","HCI");
                break;
            case "android":
                FILE_NAME= "android.txt";

                getQuestion("1","Android");
                break;
            case "comp":
                FILE_NAME = "Computer Architecture.txt";
                getQuestion("5","Comp Arki");
                break;
            case "first":
                FILE_NAME= "newly created quiz1.txt";
                getQuestion("13");
                break;
            case "second":
                FILE_NAME= "newly created quiz2.txt";
                getQuestion("14");
                break;


        }
    }
    public void getQuestion(String id){

        Integer[] intArray = { 2, 3, 4, 5 };

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);




        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> choice1 = new ArrayList<>();
        ArrayList<String> choice2 = new ArrayList<>();
        ArrayList<String> choice3 = new ArrayList<>();
        ArrayList<String> choice4 = new ArrayList<>();
        ArrayList<String> correct = new ArrayList<>();


        Cursor res = mydb.getQuizData(id);
        if(res.getCount() == 0){
//                            showMessage("Error","nothing found");
            return;
        }
//        StringBuffer stringBuffer = new StringBuffer();
        while (res.moveToNext()){
            questions.add(res.getString(1));
            choice1.add(res.getString(intArray[0]));
            choice2.add(res.getString(intArray[1]));
            choice3.add(res.getString(intArray[2]));
            choice4.add(res.getString(intArray[3]));
            correct.add(res.getString(5));


        }

        mQuestionView.setText(questions.get(mQuestionNumber));
        mButtonChoice1.setText(choice1.get(mQuestionNumber));
        mButtonChoice2.setText(choice2.get(mQuestionNumber));
        mButtonChoice3.setText(choice3.get(mQuestionNumber));
        mButtonChoice4.setText(choice4.get(mQuestionNumber));
        mAnswer = correct.get(mQuestionNumber);
        qNumber.setText("" + (mQuestionNumber + 1));
        mQuestionNumber = ((mQuestionNumber + 1) % 12) ;






    }
    public void getQuestion(String id, String name){

        Integer[] intArray = { 2, 3, 4, 5 };

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);




        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> choice1 = new ArrayList<>();
        ArrayList<String> choice2 = new ArrayList<>();
        ArrayList<String> choice3 = new ArrayList<>();
        ArrayList<String> choice4 = new ArrayList<>();
        ArrayList<String> correct = new ArrayList<>();
//        Random r = new Random();


        Cursor res = mydb.getQuizData(id);
        Cursor quizName = mydb.getQuizName(name);
        StringBuffer buffer = new StringBuffer();
        if(quizName.getCount() == 0)
            //showmesage
            return;
        while (quizName.moveToNext()){
            buffer.append(quizName.getString(1));

        }
        mExamTitle.setText(buffer.toString());
        if(res.getCount() == 0){
//                            showMessage("Error","nothing found");
            return;
        }
//        StringBuffer stringBuffer = new StringBuffer();
        while (res.moveToNext()){
            questions.add(res.getString(1));
            choice1.add(res.getString(intArray[0]));
            choice2.add(res.getString(intArray[1]));
            choice3.add(res.getString(intArray[2]));
            choice4.add(res.getString(intArray[3]));
            correct.add(res.getString(5));


        }
        mQuestionView.setText(questions.get(mQuestionNumber));
        mButtonChoice1.setText(choice1.get(mQuestionNumber));
        mButtonChoice2.setText(choice2.get(mQuestionNumber));
        mButtonChoice3.setText(choice3.get(mQuestionNumber));
        mButtonChoice4.setText(choice4.get(mQuestionNumber));
        mAnswer = correct.get(mQuestionNumber);
        qNumber.setText("" + (mQuestionNumber + 1));
        mQuestionNumber = ((mQuestionNumber + 1) % 12) ;





    }


    }




