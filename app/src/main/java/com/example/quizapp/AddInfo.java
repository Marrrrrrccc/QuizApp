package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddInfo extends AppCompatActivity {

    private String addedTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //removes notification bar and makes the app full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_info);

        TextView quizTitle = (TextView) findViewById(R.id.quizTitle);
        EditText addQuestion = (EditText) findViewById(R.id.addQuestion);
        EditText addChoice1 = (EditText) findViewById(R.id.addChoice1);
        EditText addChoice2 = (EditText) findViewById(R.id.addChoice2);
        EditText addChoice3 = (EditText) findViewById(R.id.addChoice3);
        EditText correctChoice = (EditText) findViewById(R.id.correctChoice);
        Button backButton = (Button) findViewById(R.id.backButton2);

        Intent intent = getIntent();

        addedTitle = intent.getStringExtra("title");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHomescreen();
            }
        });

        quizTitle.setText(addedTitle);

        addQuestion.setHint("Add Question");
        addChoice1.setHint("Add Choice");
        addChoice2.setHint("Add Choice");
        addChoice3.setHint("Add Choice");
        correctChoice.setHint("Add Correct Answer");

    }

    public void toHomescreen () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); //animation for transitioning back to the homescreen
    }
}