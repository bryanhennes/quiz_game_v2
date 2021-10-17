package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class Question3Activity extends AppCompatActivity {

    int score;
    CheckBox rome;
    CheckBox florence;
    CheckBox berlin;
    CheckBox milan;
    boolean romeChecked;
    boolean florenceChecked;
    boolean milanChecked;
    boolean berlinChecked;
    Button confirmAnswerButton;
    Button nextQuestionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        rome = (CheckBox)findViewById(R.id.checkbox_rome);
        florence = (CheckBox) findViewById(R.id.checkbox_florence);
        berlin = (CheckBox) findViewById(R.id.checkbox_berlin);
        milan = (CheckBox) findViewById(R.id.checkbox_milan);

        Intent recInt = getIntent();
        score = recInt.getIntExtra("Score2", score);

        confirmAnswerButton = (Button) findViewById(R.id.ConfirmQuestion3AnswerButton);
        nextQuestionButton = (Button) findViewById(R.id.moveToNextQuestionButton);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();



        // Which checkbox was selected?
        switch (view.getId()) {
            case R.id.checkbox_rome:
                if (checked) {
                   romeChecked = true;
                }
                break;
            case R.id.checkbox_florence:
                if (checked) {
                    florenceChecked= true;
                }
                break;
            case R.id.checkbox_berlin:
                if (checked) {
                    berlinChecked = true;
                }
                break;
            case R.id.checkbox_milan:
                if (checked) {
                   milanChecked = true;
                }
                break;

        }
    }

    public void checkAnswer(View view) {


        if(romeChecked && florenceChecked && milanChecked){
            score+=20;
            changeButtonVisibilities();
        }
        else if(!romeChecked && !florenceChecked && !milanChecked && !berlinChecked){
            Toast.makeText(Question3Activity.this, "Please select at least one answer", Toast.LENGTH_LONG).show();
        }
        else{
            changeButtonVisibilities();
        }

    clearCheckBoxes(view);
    }

    //reset checkBoxes
    public void clearCheckBoxes(View view){
        milanChecked = false;
        florenceChecked = false;
        berlinChecked = false;
        romeChecked = false;
        rome.setChecked(false);
        milan.setChecked(false);
        florence.setChecked(false);
        berlin.setChecked(false);
    }

    public void nextQuestion(View view) {
        Intent intent = new Intent(this, Question4Activity.class);
        intent.putExtra("Score3", score);
        this.startActivity(intent);
    }

    //when user clicks to confirm answer, remove confirm button and replace with next question button
    public void changeButtonVisibilities(){
        confirmAnswerButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.VISIBLE);
    }
}