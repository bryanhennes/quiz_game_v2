package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.bryan.myapplication.User;

public class ResultsActivity extends AppCompatActivity {
    int score;
    TextView displayScoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent recInt = getIntent();
        score = recInt.getIntExtra("Score5", score);

        displayScoreView = (TextView) findViewById(R.id.displayFinalScoreTextView);
        displayScoreView.setText(score + "/100");
    }
}