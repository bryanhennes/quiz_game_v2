package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question1Activity extends AppCompatActivity {
    int selectedAnswer;
    int score;
    Button confirmAnswerButton;
    Button nextQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        confirmAnswerButton = (Button) findViewById(R.id.ConfirmQuestion1AnswerButton);
        nextQuestionButton = (Button) findViewById(R.id.moveToNextQuestionButton);


        score = 0;
    }

    //get selected answer
    public void saveAnswer(View view) {
        selectedAnswer = view.getId();
    }

    //check if selected answer is correct after user clicks confirm answer button
    public void checkAnswer(View view) {
        if (selectedAnswer == R.id.correct_answer1){
            Toast.makeText(Question1Activity.this, "Correct", Toast.LENGTH_LONG).show();

            score+= 20;
            changeButtonVisibilities();
        }
        //makes sure user selects an answer before proceeding
        else if (selectedAnswer == 0){
            Toast.makeText(Question1Activity.this, "Please select an answer", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(Question1Activity.this, "Incorrect", Toast.LENGTH_LONG).show();
            changeButtonVisibilities();
        }

    }

    //proceed to next question activity when user clicks next question button
    public void nextQuestion(View view) {
        Intent intent = new Intent(this, Question2Activity.class);
        intent.putExtra("Score", score);
        this.startActivity(intent);
    }

    //when user clicks to confirm answer, remove confirm button and replace with next question button
    public void changeButtonVisibilities(){
        confirmAnswerButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.VISIBLE);
    }
}