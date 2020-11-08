package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class CreateQuiz extends AppCompatActivity {

    public String newTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //removes notification bar and makes the app full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_quiz);

        Button backButton = (Button) findViewById(R.id.backButton3);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        Button toQuiz = (Button) findViewById(R.id.nextButton);
        EditText quizName = (EditText) findViewById(R.id.quizName);
        EditText quizTitle = (EditText) findViewById(R.id.quizTitle);

        newTitle = quizTitle.getText().toString();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHomescreen();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHomescreen();
            }
        });
        toQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toQuestionnaire(view, newTitle);
            }
        });

        //adds hint to the two edit texts
        quizName.setHint("Quiz Name");
        quizTitle.setHint("Title");
    }

    public void toHomescreen () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); //animation for transitioning back to the homescreen
    }

    public void toQuestionnaire (View view, String v) {
        Intent intent = new Intent(this, AddInfo.class);
        intent.putExtra("title", v);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation for transitioning back to the homescreen
    }

}