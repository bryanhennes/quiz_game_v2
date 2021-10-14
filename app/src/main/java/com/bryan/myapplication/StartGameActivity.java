package com.bryan.myapplication;

import static com.bryan.myapplication.RegisterActivity.MYPREF;
import static com.bryan.myapplication.RegisterActivity.PASSWORD;
import static com.bryan.myapplication.RegisterActivity.USERNAME;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartGameActivity extends AppCompatActivity {
    Button startGameButton;
    Button registerButton;
    Dialog dialog;
    EditText usernameEdit;
    EditText passwordEdit;
    String tempUsername;
    String tempPassword;
    String savedUsername;
    String savedPassword;
    String savedFirstname;
    String savedLastname;
    String savedEmail;
    String savedDOB;
    TextView welcomeTextView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        startGameButton = (Button) findViewById(R.id.start_game_button) ;
        registerButton = (Button) findViewById(R.id.register_button);

        usernameEdit = (EditText) findViewById(R.id.username_field);
        passwordEdit = (EditText) findViewById(R.id.password_field);
        Intent recString = getIntent();
        savedUsername = recString.getStringExtra("savedUsername");
        savedPassword = recString.getStringExtra("savedPassword");
        savedFirstname = recString.getStringExtra("savedFirstName");
        savedLastname = recString.getStringExtra("savedLastName");
        savedEmail = recString.getStringExtra("savedEmail");
        savedDOB = recString.getStringExtra("savedDOB");

        welcomeTextView = (TextView) findViewById(R.id.welcome_textView); //display this textview when logged in with users name


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

    //check if credentials match, if so proceed to final activity
    public void checkCredentials(View view){
        tempUsername = usernameEdit.getText().toString();
        tempPassword = passwordEdit.getText().toString();

       sharedPreferences = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
       String preferencesUsername = sharedPreferences.getString(USERNAME, "");
       String preferencesPassword = sharedPreferences.getString(PASSWORD, "");

        //if credentials match, proceed to next activity
        if(tempUsername.equals(preferencesUsername) && tempPassword.equals(preferencesPassword)){
            successfulLogin(view);
        }
        else {
            Toast.makeText(StartGameActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
        }

    }

    //if log in successful return to original start game activity but this time make start game button visible
    public void successfulLogin(View view){
        dialog.dismiss();
        startGameButton.setVisibility(View.VISIBLE); //once logged in, start game button becomes visible
        registerButton.setVisibility(View.GONE); //and register button becomes gone

        greetUser();

    }

    //method to set textview to display greeting for signed in user and instruct how to start the game
    public void greetUser(){
        welcomeTextView.setText(getResources().getString(R.string.welcomeText) + " " + savedUsername + "! " + getResources().getString(R.string.howToStartGame));
        welcomeTextView.setVisibility(View.VISIBLE);
    }

    //when register button is clicked, move to register activity
    public void registerUser(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }

    //when clicking start game button, quiz game will begin with first question
    public void startGame(View view) {
    }
}