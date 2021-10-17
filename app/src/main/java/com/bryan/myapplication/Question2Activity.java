package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {
    int selectedAnswer;
    int score;
    Button confirmAnswerButton;
    Button nextQuestionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent recInt = getIntent();
        score = recInt.getIntExtra("Score", score);

        confirmAnswerButton = (Button) findViewById(R.id.ConfirmQuestion2AnswerButton);
        nextQuestionButton = (Button) findViewById(R.id.moveToNextQuestionButton);
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
            changeButtonVisibilities();
        }
        //makes sure user selects an answer before proceeding
        else if (selectedAnswer == 0){
            Toast.makeText(Question2Activity.this, "Please select an answer", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(Question2Activity.this, "Incorrect", Toast.LENGTH_LONG).show();
            changeButtonVisibilities();
        }
    }

    //proceed to next question activity when user clicks next question button
    public void nextQuestion(View view) {
        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra("Score2", score);
        this.startActivity(intent);
    }

    //when user clicks to confirm answer, remove confirm button and replace with next question button
    public void changeButtonVisibilities(){
        confirmAnswerButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.VISIBLE);
    }
}