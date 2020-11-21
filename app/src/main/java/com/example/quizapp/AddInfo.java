package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddInfo extends AppCompatActivity {

    private String addedTitle;
    MainActivity main = new MainActivity();
    private Integer questionNum = 0;
    EditText addQuestion, addChoice1, addChoice2, addChoice3, correctChoice;
    ImageView image;

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
        image = (ImageView) findViewById(R.id.imageView11);
        Button backButton = (Button) findViewById(R.id.backButton2);
        Button nextButton = (Button) findViewById(R.id.next2);
        final TextView questionNumber = (TextView)findViewById(R.id.qNumber2);



        Intent intent = getIntent();

        addedTitle = intent.getStringExtra("title");
        Toast.makeText(AddInfo.this, "Quiz Inserted", Toast.LENGTH_LONG).show();
//        final Cursor quizName = main.questionsDB.getQuizNameID(addedTitle);






        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHomescreen();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNumber.setText("" + (questionNum + 2));
                swipe(image);
                questionNum++;
                String qsTxt = addQuestion.getText().toString();
                String ch1 = addChoice1.getText().toString();
                String ch2 = addChoice2.getText().toString();
                String ch3 = addChoice3.getText().toString();
                String cor = correctChoice.getText().toString();
                String qNum = questionNum.toString();
                main.questionsDB.insertData(qsTxt, ch1, ch2, ch3, cor, qNum,addedTitle);
//                boolean isInserted = main.questionsDB.insertData(qsTxt, ch1, ch2, ch3, cor, qNum);
//                if (isInserted == true)
//                    Toast.makeText(AddInfo.this, "Data Inserted", Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(AddInfo.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                addQuestion.getText().clear();
                addChoice1.getText().clear();
                addChoice2.getText().clear();
                addChoice3.getText().clear();
                correctChoice.getText().clear();
                if(questionNum == 12) {
                    Toast.makeText(AddInfo.this, "Successfully Inserted the Questions", Toast.LENGTH_LONG).show();
                    toHomescreen();

                }
            }
        });

        quizTitle.setText(addedTitle);

        addQuestion.setHint("Add Question");
        addChoice1.setHint("Add Choice");
        addChoice2.setHint("Add Choice");
        addChoice3.setHint("Add Choice");
        correctChoice.setHint("Add Correct Answer");

    }

    private void swipe (View v){
        Animation swipe = AnimationUtils.loadAnimation(AddInfo.this, R.anim.swipe);
        v.setAnimation(swipe);
    }

    public void toHomescreen () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); //animation for transitioning back to the homescreen
    }
}