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
    private AddInfo addInfo = new AddInfo();

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
//                save(view,FILE_NAME);
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
//                FILE_NAME = "programming.txt";//set the name of the file
//                xmlQuestion("Programming",R.array.questionProg,R.array.choicesProg,R.array.correctProg);
                getQuestion("10","Programming");
                break;
            case "Aos":
//                FILE_NAME = "Aos.txt";
//                xmlQuestion("AOS",R.array.questionAos,R.array.choicesAos,R.array.correctAos);
                getQuestion("2","AOS");

                break;
            case "FRONT-END":
//                FILE_NAME = "front-end.txt";
//                xmlQuestion("Front End",R.array.questionsFront,R.array.choicesFront,R.array.correctFront);
                getQuestion("7","Front-end");
                break;
            case "DATA ALGO":
//                FILE_NAME = "Data-Algo.txt";
//                xmlQuestion("Data Algorithm",R.array.questionDataAlgo,R.array.choicesDataAlgo,R.array.correctDataAlgo);
                getQuestion("4","Data Algo");
                break;
            case "OS":
//                FILE_NAME = "operating system.txt";
//                xmlQuestion("Operating System",R.array.questionOs,R.array.choicesOs,R.array.correctOs);
                getQuestion("9","OS");
                break;
            case "DM":
//                FILE_NAME= "Discrete.txt";
//                xmlQuestion("Discrete Math",R.array.questionDiscrete,R.array.choicesDiscrete,R.array.correctDiscrete);
                getQuestion("3", "Discrete Math");
                break;
            case "ETHICS":
//                FILE_NAME= "Ethics.txt";
//                xmlQuestion("Ethics",R.array.questionEthics,R.array.choicesEthics,R.array.correctEthics);
                getQuestion("6","Ethics");
                break;
            case "VB":
//                FILE_NAME= "Visual-basic.txt";
//                xmlQuestion("Visual Basic",R.array.questionVb,R.array.choicesVb,R.array.correctVb);
                getQuestion("11","VB");
                break;
            case "HCI":
//                FILE_NAME= "HCI.txt";
//                xmlQuestion("HCI",R.array.questionHci,R.array.choicesHci,R.array.correctHci);
                getQuestion("8","HCI");
                break;
            case "android":
//                FILE_NAME= "android.txt";
//                xmlQuestion("Android",R.array.questionAndroid,R.array.choicesAndroid,R.array.correctAndroid);
                getQuestion("1","Android");
                break;
            case "comp":
                getQuestion("5","Comp Arki");
//                FILE_NAME= "Computer Architecture.txt";
//                xmlQuestion("Comp Archi",R.array.questionCompArki,R.array.choicesCompArki,R.array.correctCompArki);
                break;
//            case "first":
//                getQuestion(addInfo.addedTitle);
//                break;



        }
    }
    public void getQuestion(String id){


        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> choice1 = new ArrayList<>();
        ArrayList<String> choice2 = new ArrayList<>();
        ArrayList<String> choice3 = new ArrayList<>();
        ArrayList<String> choice4 = new ArrayList<>();
        ArrayList<String> correct = new ArrayList<>();
//        Random r = new Random();


        Cursor res = mydb.getQuizData(id);
        if(res.getCount() == 0){
//                            showMessage("Error","nothing found");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (res.moveToNext()){
            questions.add(res.getString(1));
            choice1.add(res.getString(2));
            choice2.add(res.getString(3));
            choice3.add(res.getString(4));
            choice4.add(res.getString(5));
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
            choice1.add(res.getString(2));
            choice2.add(res.getString(3));
            choice3.add(res.getString(4));
            choice4.add(res.getString(5));
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

    public void xmlQuestion(String title,int question,int choice, int correctAnswer){
        Resources res = getResources();
        questions = res.getStringArray(question);
        mQuestionView.setText(questions[mQuestionNumber]);
        choices = res.getStringArray(choice);
        String[] correct = res.getStringArray(correctAnswer);
        String[] mainchoice = choices[mQuestionNumber].split(",");
        mButtonChoice1.setText(mainchoice[0]);
        mButtonChoice2.setText(mainchoice[1]);
        mButtonChoice3.setText(mainchoice[2]);
        mButtonChoice4.setText(mainchoice[3]);
        mAnswer = correct[mQuestionNumber];
        qNumber.setText("" + (mQuestionNumber + 1));
        mQuestionNumber = ((mQuestionNumber + 1) % questions.length) ;
        mExamTitle.setText(title);
    }
//    public void txtQuestions(String filename) {
//
//        try {
//            FileInputStream fileInputStream = openFileInput(filename);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuffer q = new StringBuffer();
//            ArrayList<String> questions = new ArrayList<>();
//            ArrayList<String> choice1 = new ArrayList<>();
//            ArrayList<String> choice2 = new ArrayList<>();
//            ArrayList<String> choice3 = new ArrayList<>();
//            ArrayList<String> choice4 = new ArrayList<>();
//            ArrayList<String> correct = new ArrayList<>();
//            ArrayList<String> title = new ArrayList<>();
//            String line = bufferedReader.readLine();
//            while (line!= null) {
//                if (line.contains("Title:")){
//                    line = line.replace("Title:","");
//                    title.add(line);
//                }
//                if(line.contains("Question:")){
//                    line = line.replace("Question:","");
//                    questions.add(line);
//
//                }
//                if(line.contains("Choice1:")){
//                    line = line.replace("Choice1:", "");
//                    choice1.add(line);
//
//                }
//                if(line.contains("Choice2:")){
//                    line = line.replace("Choice2:", "");
//                    choice2.add(line);
//
//                }
//                if(line.contains("Choice3:")){
//                    line = line.replace("Choice3:", "");
//                    choice3.add(line);
//
//                }
//                if(line.contains("Choice4:")){
//                    line = line.replace("Choice4:", "");
//                    choice4.add(line);
//
//                }if(line.contains("correct answer:")){
//                    line = line.replace("correct answer:", "");
//                    correct.add(line);
//
//                }
//                line = bufferedReader.readLine();
//
//            }
//            bufferedReader.close();
//
//            q.append(questions.get(mQuestionNumber));
//            mQuestionView.setText(q);
//            mButtonChoice1.setText(choice1.get(mQuestionNumber));
//            mButtonChoice2.setText(choice2.get(mQuestionNumber));
//            mButtonChoice3.setText(choice3.get(mQuestionNumber));
//            mButtonChoice4.setText(choice4.get(mQuestionNumber));
//            mAnswer = correct.get(mQuestionNumber);
//            qNumber.setText("" + (mQuestionNumber + 1));
//            mQuestionNumber = ((mQuestionNumber + 1) % questions.size()) ;
//
//            mExamTitle.setText(title.get(0));
//        } catch(FileNotFoundException ex){
//            ex.printStackTrace();
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }

       /* private void slideRight (View v){
            Animation slide = AnimationUtils.loadAnimation(insideQuiz.this, R.anim.slide_in_right);
            v.setAnimation(slide);

        }

        private void slideLeft (View v){
            Animation slide = AnimationUtils.loadAnimation(insideQuiz.this, R.anim.slide_in_left);
            v.setAnimation(slide);

        } */

    }




