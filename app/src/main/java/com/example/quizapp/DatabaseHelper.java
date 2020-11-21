package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Questions.db";
    public static final String TABLE_NAME_1 = "Quiz_Table";
    public static final String T1_COL_1 = "Quiz_ID";
    public static final String T1_COL_2 = "Quiz_Name";

    public static final String TABLE_NAME_2 = "Question_Table";
    public static final String T2_COL_1 = "Question_ID";
    public static final String T2_COL_2 = "Question";
    public static final String T2_COL_3 = "Choice_1";
    public static final String T2_COL_4 = "Choice_2";
    public static final String T2_COL_5 = "Choice_3";
    public static final String T2_COL_6 = "Correct";
    public static final String T2_COL_7 = "Question_num";
    public static final String T2_COL_8 = "Quiz_ID";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Quiz_Table (" +
                "Quiz_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Quiz_Name TEXT)");

        db.execSQL("CREATE TABLE Question_Table (" +
                "Question_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Question TEXT, " +
                "Choice_1 TEXT, " +
                "Choice_2 TEXT, " +
                "Choice_3 TEXT, " +
                "Correct TEXT, " +
                "Question_num INTEGER, " +
                "Quiz_ID INTEGER, " +
                "FOREIGN KEY (Quiz_ID) REFERENCES Quiz_Table(Quiz_ID))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Quiz_Table");
        db.execSQL("DROP TABLE IF EXISTS Question_Table");
        onCreate(db);
    }

    public boolean insertData (String question, String Choice_1, String Choice_2, String Choice_3, String Correct, String Question_num,String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T2_COL_2,question);
        contentValues.put(T2_COL_3,Choice_1);
        contentValues.put(T2_COL_4,Choice_2);
        contentValues.put(T2_COL_5,Choice_3);
        contentValues.put(T2_COL_6,Correct);
        contentValues.put(T2_COL_7,Question_num);
        contentValues.put(T2_COL_8,Id);
        long result = db.insert(TABLE_NAME_2, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertQuiz (String quizName) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL_2, quizName);

        long result = db.insert(TABLE_NAME_1, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getQuizData(String id){//reading the data to the database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME_2 + " WHERE Quiz_Id = ? ",new String[] {id});

        return res;
    }
    public Cursor getQuizName(String QuizName){//reading the data to the database
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+ TABLE_NAME_1 + " WHERE Quiz_Name = ?",new String[] {QuizName});
        return res;
    }
    public Cursor getQuizNameID(String id){//reading the data to the database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select Quiz_Name from "+ TABLE_NAME_1 + " WHERE Quiz_Id = ?",new String[]{id});
        res.getString(0);
        return res;
    }



}
