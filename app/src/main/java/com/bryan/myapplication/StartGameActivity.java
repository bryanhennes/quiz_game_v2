package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class StartGameActivity extends AppCompatActivity {
    Button startGameButton;
    Dialog dialog;
    EditText usernameEdit;
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        usernameEdit = (EditText) findViewById(R.id.username_field);
        passwordEdit = (EditText) findViewById(R.id.password_field);


    }
    //when login button is clicked, load dialog to enter username and password
    public void enterCredentials(View view){
        dialog = new Dialog(StartGameActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);

        usernameEdit = dialog.findViewById(R.id.username_field);
        passwordEdit = dialog.findViewById(R.id.password_field);

        dialog.show();
    }



    //when register button is clicked, move to register activity
    public void registerUser(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }
}