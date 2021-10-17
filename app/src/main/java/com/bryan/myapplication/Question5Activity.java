package com.bryan.myapplication;

import static com.bryan.myapplication.RegisterActivity.MYPREF;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question5Activity extends AppCompatActivity {
    int score;
    int selectedAnswer;

    Button confirmAnswerButton;
    Button nextQuestionButton;
    SharedPreferences sharedPreferences;
    int sharedPreferencesScore;
    int highScore;
    public static final String HIGHSCORE = "HIGHSCORE_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        Intent recInt = getIntent();
        score = recInt.getIntExtra("Score4", score);
        sharedPreferences = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);


        confirmAnswerButton = (Button) findViewById(R.id.ConfirmQuestion5AnswerButton);
        nextQuestionButton = (Button) findViewById(R.id.moveToNextQuestionButton);
    }

    public void saveAnswer(View view) {
        selectedAnswer = view.getId();

    }

    public void checkAnswer(View view) {
        if (selectedAnswer == R.id.question5_correctAnswer){
            score+= 20;
            changeButtonVisibilities();
        }
        //makes sure user selects an answer before proceeding
        else if (selectedAnswer == 0){
            Toast.makeText(Question5Activity.this, "Please select an answer", Toast.LENGTH_LONG).show();

        }
        else {
            changeButtonVisibilities();
        }
    }

    public void seeResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra("Score5", score);
        sharedPreferences = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(!sharedPreferences.contains(HIGHSCORE)){
            editor.putInt(HIGHSCORE, score);
            editor.commit();
            editor.apply();
        }
        else{
            sharedPreferencesScore = sharedPreferences.getInt(HIGHSCORE, score);
            if(score > sharedPreferencesScore){
                editor.putInt(HIGHSCORE, score);
                editor.commit();
                editor.apply();
            }
        }

        this.startActivity(intent);
    }

    //when user clicks to confirm answer, remove confirm button and replace with next question button
    public void changeButtonVisibilities(){
        confirmAnswerButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.VISIBLE);
    }
}