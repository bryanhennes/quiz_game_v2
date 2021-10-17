package com.bryan.myapplication;

import static com.bryan.myapplication.RegisterActivity.MYPREF;
import static com.bryan.myapplication.RegisterActivity.USERNAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import com.bryan.myapplication.User;

import org.w3c.dom.Text;

public class ResultsActivity extends AppCompatActivity {
    int score;
    int highscore;
    TextView displayScoreView;
    TextView displayHighscoreView;
    SharedPreferences sharedPreferences;
    public static final String HIGHSCORE = "HIGHSCORE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        sharedPreferences = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);

        Intent recInt = getIntent();
        score = recInt.getIntExtra("Score5", score);


        int sharedPreferencesScore = sharedPreferences.getInt(HIGHSCORE, highscore);


        displayScoreView = (TextView) findViewById(R.id.displayFinalScoreTextView);
        displayHighscoreView = (TextView) findViewById(R.id.displayHighScoreTextView);
        displayScoreView.setText("Good job " + sharedPreferences.getString(USERNAME, "") + "! \nYour score is " + score + "/100");
        displayHighscoreView.setText("Highscore: " + sharedPreferencesScore + "/100");



    }


}