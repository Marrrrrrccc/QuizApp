package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class insideQuiz extends AppCompatActivity {
    private questionLibrary mQuestionLibrary = new questionLibrary();
    private dataAlgo mDataAlgo = new dataAlgo();
    private frontEnd mFrontEnd = new frontEnd();
    private cisco cisco = new cisco();
    private Aos Aos = new Aos();
    private oS mOS = new oS();
    private discreteMath DM = new discreteMath();
    private ethics mEthics = new ethics();
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

    private String mAnswer;
    private int counter = 0;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String toast;
    private Button mButtonNext;
    private CardView cardView;
    private String quiz;

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
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);
        mButtonNext = findViewById(R.id.next);
        quiz = String.valueOf(getIntent().getStringExtra("quiz"));
//        if(quiz.equalsIgnoreCase("cisco1")){
//            ciscoQuestion();
//        }else if(quiz.equalsIgnoreCase("programming")){
//            programmingQuestion();
//        }
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
                if (mButtonChoice1.getText() == mAnswer) {
                    mButtonChoice1.setBackgroundColor(Color.GREEN);
                } else {
                    mButtonChoice1.setBackgroundColor(Color.RED);
                }

            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                //logic starts here
                if (mButtonChoice2.getText() == mAnswer) {
                    mButtonChoice2.setBackgroundColor(Color.GREEN);
                } else {
                    mButtonChoice2.setBackgroundColor(Color.RED);
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                //logic starts here
                if (mButtonChoice3.getText() == mAnswer) {
                    mButtonChoice3.setBackgroundColor(Color.GREEN);
                } else {
                    mButtonChoice3.setBackgroundColor(Color.RED);
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                //logic starts here
                if (mButtonChoice4.getText() == mAnswer) {
                    mButtonChoice4.setBackgroundColor(Color.GREEN);
                } else {
                    mButtonChoice4.setBackgroundColor(Color.RED);
                }
            }
        });
        //method to go to the next questions
        mButtonNext.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("ResourceAsColor")
            public void onClick(View view){
              updateQuestion();
                save(view,FILE_NAME);
                mButtonChoice1.setBackgroundResource(android.R.drawable.btn_default);//brings back the color of each button
                mButtonChoice2.setBackgroundResource(android.R.drawable.btn_default);
                mButtonChoice3.setBackgroundResource(android.R.drawable.btn_default);
                mButtonChoice4.setBackgroundResource(android.R.drawable.btn_default);
                slideAnimation(mButtonChoice1);//sets the animations
                slideAnimation(mButtonChoice2);
                slideAnimation(mButtonChoice3);
                slideAnimation(mButtonChoice4);
                slideAnimation(cardView);
            }
        });


    }


        //method for going back to the homescreen
        public void toHomescreen () {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


        //method the updates the question


//        private void updatescore(int point){
//
//        mScoreView.setText("" + mScore);
//    }
        //method to set the animations
        private void slideAnimation (View v){
            Animation slide = AnimationUtils.loadAnimation(insideQuiz.this, R.anim.slide_in_right);
            v.setAnimation(slide);


        }
        //method that save the question to a text file

    public void save(View v,String name) {
        String question = "Question:" + mQuestionView.getText().toString();
        String choice1 = "Choice:" + mButtonChoice1.getText().toString();
        String choice2 = "Choice:" + mButtonChoice2.getText().toString();
        String choice3 = "Choice:" + mButtonChoice3.getText().toString();
        String choice4 = "Choice:" + mButtonChoice4.getText().toString();
        String correctAnswer = "correct answer: " +mAnswer;
        counter++;
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
                programmingQuestion();
                FILE_NAME = "programming.txt";//set the name of the file
                break;
            case "operating system":
                operatingSystemQuestion();
                FILE_NAME = "operating system.txt";
                break;
            case "Aos":
                AOSQuestion();
                FILE_NAME = "Aos.txt";
                break;
            case "FRONT-END":
                frontENDQuestion();
                FILE_NAME = "front-end.txt";
                break;
            case "DATA ALGO":
                dataalgoQuestion();
                FILE_NAME = "DATA-ALGO.txt";
                break;
            case "OS":
                OSQuestion();
                FILE_NAME = "OS.txt";
                break;
            case "DM":
                DMQuestion();
                FILE_NAME= "Discrete.txt";
                break;
            case "ETHICS":
                ethicsQuestion();
                FILE_NAME= "Ethics.txt";
                break;



        }
    }
    public void operatingSystemQuestion() {
        mExamTitle.setText(cisco.title);
        mQuestionView.setText(cisco.getmQuestions(mQuestionNumber));
        mButtonChoice1.setText(cisco.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(cisco.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(cisco.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(cisco.getChoice4(mQuestionNumber));
        mAnswer = cisco.getCorrectAnswer(mQuestionNumber);
        qNumber.setText("" + (mQuestionNumber + 1));
        mQuestionNumber = ((mQuestionNumber + 1) % cisco.mQuestions.length);

    }
    public void programmingQuestion() {//
        mExamTitle.setText(mQuestionLibrary.title);//displays the title
        mQuestionView.setText(mQuestionLibrary.getmQuestions(mQuestionNumber));//displays the question
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));//displays the choices
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);//para ma determine yung tamang sagot
        qNumber.setText("" + (mQuestionNumber + 1));//set pangilang question na
        mQuestionNumber = ((mQuestionNumber + 1) % mQuestionLibrary.mQuestions.length);//para bumalik sa una pag dulo na yung questions

    }
    public void AOSQuestion() {//
        mExamTitle.setText(Aos.title);//displays the title
        mQuestionView.setText(Aos.getmQuestions(mQuestionNumber));//displays the question
        mButtonChoice1.setText(Aos.getChoice1(mQuestionNumber));//displays the choices
        mButtonChoice2.setText(Aos.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(Aos.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(Aos.getChoice4(mQuestionNumber));
        mAnswer = Aos.getCorrectAnswer(mQuestionNumber);//para ma determine yung tamang sagot
        qNumber.setText("" + (mQuestionNumber + 1));//set pangilang question na
        mQuestionNumber = ((mQuestionNumber + 1) % mQuestionLibrary.mQuestions.length);//para bumalik sa una pag dulo na yung questions

    }
    public void frontENDQuestion() {//
        mExamTitle.setText(mFrontEnd.title);//displays the title
        mQuestionView.setText(mFrontEnd.getmQuestions(mQuestionNumber));//displays the question
        mButtonChoice1.setText(mFrontEnd.getChoice1(mQuestionNumber));//displays the choices
        mButtonChoice2.setText(mFrontEnd.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mFrontEnd.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mFrontEnd.getChoice4(mQuestionNumber));
        mAnswer = mFrontEnd.getCorrectAnswer(mQuestionNumber);//para ma determine yung tamang sagot
        qNumber.setText("" + (mQuestionNumber + 1));//set pangilang question na
        mQuestionNumber = ((mQuestionNumber + 1) % mQuestionLibrary.mQuestions.length);//para bumalik sa una pag dulo na yung questions

    }
    public void dataalgoQuestion() {//
        mExamTitle.setText(mDataAlgo.title);//displays the title
        mQuestionView.setText(mDataAlgo.getmQuestions(mQuestionNumber));//displays the question
        mButtonChoice1.setText(mDataAlgo.getChoice1(mQuestionNumber));//displays the choices
        mButtonChoice2.setText(mDataAlgo.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mDataAlgo.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mDataAlgo.getChoice4(mQuestionNumber));
        mAnswer = mDataAlgo.getCorrectAnswer(mQuestionNumber);//para ma determine yung tamang sagot
        qNumber.setText("" + (mQuestionNumber + 1));//set pangilang question na
        mQuestionNumber = ((mQuestionNumber + 1) % mQuestionLibrary.mQuestions.length);//para bumalik sa una pag dulo na yung questions

    }
    public void OSQuestion() {//
        mExamTitle.setText(mOS.title);//displays the title
        mQuestionView.setText(mOS.getmQuestions(mQuestionNumber));//displays the question
        mButtonChoice1.setText(mOS.getChoice1(mQuestionNumber));//displays the choices
        mButtonChoice2.setText(mOS.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mOS.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mOS.getChoice4(mQuestionNumber));
        mAnswer = mOS.getCorrectAnswer(mQuestionNumber);//para ma determine yung tamang sagot
        qNumber.setText("" + (mQuestionNumber + 1));//set pangilang question na
        mQuestionNumber = ((mQuestionNumber + 1) % mQuestionLibrary.mQuestions.length);//para bumalik sa una pag dulo na yung questions

    }
    public void DMQuestion() {//
        mExamTitle.setText(DM.title);//displays the title
        mQuestionView.setText(DM.getmQuestions(mQuestionNumber));//displays the question
        mButtonChoice1.setText(DM.getChoice1(mQuestionNumber));//displays the choices
        mButtonChoice2.setText(DM.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(DM.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(DM.getChoice4(mQuestionNumber));
        mAnswer = DM.getCorrectAnswer(mQuestionNumber);//para ma determine yung tamang sagot
        qNumber.setText("" + (mQuestionNumber + 1));//set pangilang question na
        mQuestionNumber = ((mQuestionNumber + 1) % mQuestionLibrary.mQuestions.length);//para bumalik sa una pag dulo na yung questions

    }
    public void ethicsQuestion() {//
        mExamTitle.setText(mEthics.title);//displays the title
        mQuestionView.setText(mEthics.getmQuestions(mQuestionNumber));//displays the question
        mButtonChoice1.setText(mEthics.getChoice1(mQuestionNumber));//displays the choices
        mButtonChoice2.setText(mEthics.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mEthics.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mEthics.getChoice4(mQuestionNumber));
        mAnswer = mEthics.getCorrectAnswer(mQuestionNumber);//para ma determine yung tamang sagot
        qNumber.setText("" + (mQuestionNumber + 1));//set pangilang question na
        mQuestionNumber = ((mQuestionNumber + 1) % mQuestionLibrary.mQuestions.length);//para bumalik sa una pag dulo na yung questions

    }
    }




