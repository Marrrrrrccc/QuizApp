package com.example.quizapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Questions.db";
    public static final String TABLE_NAME_1 = "Quiz_Table";
    public static final String T1_COL_1 = "Quiz_ID";
    public static final String T1_COL_2 = "Quiz_Name";
    public static final String T1_COL_3 = "Question_ID";

    public static final String TABLE_NAME_2 = "Question_Table";
    public static final String T2_COL_1 = "Question_ID";
    public static final String T2_COL_2 = "Question";
    public static final String T2_COL_3 = "Choice_ID";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE Quiz_Table (Quiz_ID INT(50) NOT NULL PRIMARY KEY, Quiz_Name VARCHAR(100) NOT NULL, Question_ID INT(50) NOT NULL, FOREIGN KEY (Question_ID) REFERENCES Question_Table(Question_ID))");
//        db.execSQL("CREATE TABLE Question_Table (Question_ID INT(50) NOT NULL PRIMARY KEY, Question VARCHAR(100) NOT NULL, Choice_ID INT(50) NOT NULL, FOREIGN KEY (Choice_ID) REFERENCES Choice_Table(Choice_ID))");
//        db.execSQL("CREATE TABLE Choice_Table (Choice_ID INT(50) NOT NULL PRIMARY KEY, Choice_1 VARCHAR(100) NOT NULL, Choice_2 VARCHAR(100) NOT NULL, Choice_3 VARCHAR(100) NOT NULL, Correct_Answer VARCHAR(100) NOT NULL, Quiz_ID INT(50) NOT NULL, FOREIGN KEY (Quiz_ID) REFERENCES Quiz_Table(Quiz_ID))");

        db.execSQL("CREATE TABLE Quiz_Table (" +
                "Quiz_ID INT(50) NOT NULL PRIMARY KEY, " +
                "Quiz_Name VARCHAR(100) NOT NULL)");

        db.execSQL("CREATE TABLE Question_Table (" +
                "Question_ID INT(50) NOT NULL PRIMARY KEY, " +
                "Question VARCHAR(100) NOT NULL, " +
                "Choice_1 VARCHAR(100) NOT NULL, " +
                "Choice_2 VARCHAR(100) NOT NULL, " +
                "Choice_3 VARCHAR(100) NOT NULL, " +
                "Correct VARCHAR(100) NOT NULL, " +
                "Question_num INT(50) NOT NULL, " +
                "Quiz_ID INT(50) NOT NULL, " +
                "FOREIGN KEY (Quiz_ID) REFERENCES Quiz_Table(Quiz_ID))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Quiz_Table");
        db.execSQL("DROP TABLE IF EXISTS Question_Table");
        onCreate(db);
    }

}
