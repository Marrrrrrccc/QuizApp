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
import android.widget.Toast;

public class AddInfo extends AppCompatActivity {

    private String addedTitle;
    MainActivity main = new MainActivity();
    private Integer questionNum = 0;
    EditText addQuestion, addChoice1, addChoice2, addChoice3, correctChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //removes notification bar and makes the app full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_info);

        main.questionsDB = new DatabaseHelper(this);
        TextView quizTitle = (TextView) findViewById(R.id.quizTitle);
        addQuestion = (EditText) findViewById(R.id.addQuestion);
        addChoice1 = (EditText) findViewById(R.id.addChoice1);
        addChoice2 = (EditText) findViewById(R.id.addChoice2);
        addChoice3 = (EditText) findViewById(R.id.addChoice3);
        correctChoice = (EditText) findViewById(R.id.correctChoice);
        Button backButton = (Button) findViewById(R.id.backButton2);
        Button nextButton = (Button) findViewById(R.id.next2);

        Intent intent = getIntent();

        addedTitle = intent.getStringExtra("title");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHomescreen();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNum++;
                String qsTxt = addQuestion.getText().toString();
                String ch1 = addChoice1.getText().toString();
                String ch2 = addChoice2.getText().toString();
                String ch3 = addChoice3.getText().toString();
                String cor = correctChoice.getText().toString();
                String qNum = questionNum.toString();
                boolean isInserted = main.questionsDB.insertData("asd","dsa","sda","Dasd","asd","1");
                if (isInserted == true)
                    Toast.makeText(AddInfo.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddInfo.this, "Data not Inserted", Toast.LENGTH_LONG).show();
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