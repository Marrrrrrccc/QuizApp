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
import android.widget.Toast;

public class CreateQuiz extends AppCompatActivity {

    public String newTitle;
    MainActivity main = new MainActivity();
    EditText quizName;
    Button toQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //removes notification bar and makes the app full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_quiz);

        main.questionsDB = new DatabaseHelper(this);

        Button backButton = (Button) findViewById(R.id.backButton3);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        toQuiz = (Button) findViewById(R.id.nextButton);
        quizName = (EditText) findViewById(R.id.quizName);
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

        //adds hint to the two edit texts
        quizName.setHint("Quiz Name");
        quizTitle.setHint("Title");
        AddQuiz();
    }

    public void AddQuiz() {
        toQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toQuestionnaire(view, newTitle);
                String qName = quizName.getText().toString();
                boolean isInserted = main.questionsDB.insertQuiz(qName);
                if (isInserted == true)
                    Toast.makeText(CreateQuiz.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(CreateQuiz.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });

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