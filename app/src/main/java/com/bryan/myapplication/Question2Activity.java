package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {
    int selectedAnswer;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    }

    //get selected answer
    public void saveAnswer(View view) {
        selectedAnswer = view.getId();
    }

    //check if selected answer is correct after user clicks confirm answer button
    public void checkAnswer(View view) {
        if (selectedAnswer == R.id.question2_correctAnswer){
            Toast.makeText(Question2Activity.this, "Correct", Toast.LENGTH_LONG).show();

            score+= 20;
        }
        //makes sure user selects an answer before proceeding
        else if (selectedAnswer == 0){
            Toast.makeText(Question2Activity.this, "Please select an answer", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(Question2Activity.this, "Incorrect", Toast.LENGTH_LONG).show();
    }

    //proceed to next question activity when user clicks next question button
    public void nextQuestion(View view) {
        Intent intent = new Intent(this, Question3Activity.class);
        this.startActivity(intent);
    }
}