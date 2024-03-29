package com.example.quizapp;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//implements onclick listener to make all buttons go to one xml
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private insideQuiz insideQuiz1 = new insideQuiz();
    public Button openQuiz1;
    public Button openQuiz2;
    private Intent i;
    public DatabaseHelper questionsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //removes notification bar and makes the app full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        questionsDB = new DatabaseHelper(this);

        openQuiz1 = (Button) findViewById(R.id.quiz1);
         openQuiz2 = (Button) findViewById(R.id.button2);
        Button openQuiz3 = (Button) findViewById(R.id.button3);
        Button openQuiz4 = (Button) findViewById(R.id.button4);
        Button openQuiz5 = (Button) findViewById(R.id.button5);
        Button openQuiz6 = (Button) findViewById(R.id.button6);
        Button openQuiz7 = (Button) findViewById(R.id.button7);
        Button openQuiz8 = (Button) findViewById(R.id.button8);
        Button openQuiz9 = (Button) findViewById(R.id.button9);
        Button openQuiz10 = (Button) findViewById(R.id.button10);
        Button openQuiz11 = (Button) findViewById(R.id.button11);
        Button openQuiz12 = (Button)findViewById(R.id.button12);
        Button openQuiz13 = (Button)findViewById(R.id.button13);
        Button addNewFile = (Button) findViewById(R.id.addNewFile);

        openQuiz1.setOnClickListener(this);
        openQuiz2.setOnClickListener(this);
        openQuiz3.setOnClickListener(this);
        openQuiz4.setOnClickListener(this);
        openQuiz5.setOnClickListener(this);
        openQuiz6.setOnClickListener(this);
        openQuiz7.setOnClickListener(this);
        openQuiz8.setOnClickListener(this);
        openQuiz9.setOnClickListener(this);
        openQuiz10.setOnClickListener(this);
        openQuiz11.setOnClickListener(this);
        openQuiz12.setOnClickListener(this);
        openQuiz13.setOnClickListener(this);
        addNewFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAddFile();
            }
        });
    }



    //onclick method for the buttons
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quiz1:
                openQuizAct(view,"programming");
                break;
            case R.id.button2:
                openQuizAct(view,"OS");
                break;
            case R.id.button3:
                openQuizAct(view,"Aos");
                break;
            case R.id.button4:
                openQuizAct(view,"FRONT-END");
                break;
            case R.id.button5:
                openQuizAct(view,"DATA ALGO");
                break;
            case R.id.button6:
                openQuizAct(view,"comp");
                break;
            case R.id.button7:
                openQuizAct(view,"DM");
                break;
            case R.id.button8:
                openQuizAct(view,"ETHICS");
                break;
            case R.id.button9:
                openQuizAct(view,"VB");
                break;
            case R.id.button10:
                openQuizAct(view,"HCI");
                break;
            case R.id.button11:
                openQuizAct(view,"android");
                break;
            case R.id.button12:
                openQuizAct(view,"first");
                break;
            case R.id.button13:
                openQuizAct(view,"second");
                break;
        }
    }

    //method for going inside quiz
    public void openQuizAct(View view,String v) {
      i = new Intent(MainActivity.this, insideQuiz.class);
      i.putExtra("quiz",v);//para malipat yung data from this to the other activities
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void toAddFile() {
        Intent intent = new Intent(this, CreateQuiz.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation for transitioning back to the homescreen
    }
}