package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button playGameButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this button will start game as long as user is logged in
        playGameButton = (Button) findViewById(R.id.play_game_button);
    }


    //when play game button is clicked, move to start game activity
    public void moveToStartGameActivity(View view) {
        Intent intent = new Intent(this, StartGameActivity.class);
        this.startActivity(intent);
    }
}