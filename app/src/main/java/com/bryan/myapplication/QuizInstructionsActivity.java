package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuizInstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_instructions);
    }

    //bring user to question 1 activity
    public void beginQuiz(View view) {
        Intent intent = new Intent(this, Question1Activity.class);
        this.startActivity(intent);
    }
}