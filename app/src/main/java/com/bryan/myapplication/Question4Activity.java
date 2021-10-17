package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question4Activity extends AppCompatActivity {
    int score;
    int selectedAnswer;

    Button confirmAnswerButton;
    Button nextQuestionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        Intent recInt = getIntent();
        score = recInt.getIntExtra("Score3", score);

        confirmAnswerButton = (Button) findViewById(R.id.ConfirmQuestion4AnswerButton);
        nextQuestionButton = (Button) findViewById(R.id.moveToNextQuestionButton);
    }

    public void saveAnswer(View view) {
        selectedAnswer = view.getId();
    }

    public void checkAnswer(View view) {
        if (selectedAnswer == R.id.question4_correctAnswer){
            score+= 20;
            changeButtonVisibilities();
        }
        //makes sure user selects an answer before proceeding
        else if (selectedAnswer == 0){
            Toast.makeText(Question4Activity.this, "Please select an answer", Toast.LENGTH_LONG).show();

        }
        else {
            changeButtonVisibilities();
        }
    }

    public void nextQuestion(View view) {
        Intent intent = new Intent(this, Question5Activity.class);
        intent.putExtra("Score4", score);
        this.startActivity(intent);
    }

    //when user clicks to confirm answer, remove confirm button and replace with next question button
    public void changeButtonVisibilities(){
        confirmAnswerButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.VISIBLE);
    }
}