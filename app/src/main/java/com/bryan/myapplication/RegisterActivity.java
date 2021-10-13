package com.bryan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText firstNameEdit;
    EditText lastNameEdit;
    EditText dobEdit;
    EditText emailEdit;
    EditText userNameEdit;
    EditText passwordEdit;
    SharedPreferences sharedPreferences;
    public static final String MYPREF = "MY_PREF_FILE";
    public static final String FIRSTNAME = "FIRST_NAME_KEY";
    public static final String LASTNAME = "LAST_NAME_KEY";
    public static final String DOB = "DOB_KEY";
    public static final String EMAIL = "EMAIL_KEY";
    public static final String USERNAME = "USERNAME_KEY";
    public static final String PASSWORD = "PASSWORD_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //assign edittext fields
        firstNameEdit = (EditText) findViewById(R.id.first_name_field);
        lastNameEdit = (EditText) findViewById(R.id.last_name_field);
        dobEdit = (EditText) findViewById(R.id.dob_field);
        emailEdit = (EditText) findViewById(R.id.email_field);
        userNameEdit = (EditText) findViewById(R.id.username_field_edit);
        passwordEdit = (EditText) findViewById(R.id.password_field_edit);
        sharedPreferences = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
    }

    //save data once done registering
    public void saveData(View view) {
        //as long as fields are not blank, save data as strings and return to login page
        if (!fieldEmpty(firstNameEdit) && !fieldEmpty(lastNameEdit) && !fieldEmpty(dobEdit) && !fieldEmpty(emailEdit) && !fieldEmpty(userNameEdit) && !fieldEmpty(passwordEdit)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String firstName = firstNameEdit.getText().toString();
            String lastName = lastNameEdit.getText().toString();
            String dob = dobEdit.getText().toString();
            String userName = userNameEdit.getText().toString();
            String email = emailEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            editor.putString(FIRSTNAME, firstName);
            editor.putString(LASTNAME, lastName);
            editor.putString(DOB, dob);
            editor.putString(USERNAME, userName);
            editor.putString(EMAIL, email);
            editor.putString(PASSWORD, password);
            editor.apply();
            returnToLogin(view); //return to login page
        } else {
            Toast.makeText(RegisterActivity.this, "Cannot leave any fields blank", Toast.LENGTH_LONG).show(); //prompt user to not leave fields blank
            highlightEmptyFields(firstNameEdit);
            highlightEmptyFields(lastNameEdit);
            highlightEmptyFields(dobEdit);
            highlightEmptyFields(emailEdit);
            highlightEmptyFields(userNameEdit);
            highlightEmptyFields(passwordEdit);
        }
    }
    public void returnToLogin(View view){

    }
    //check if field is empty or not
    public boolean fieldEmpty(EditText field) {
        String fieldText = field.getText().toString();
        boolean result = false;
        if (fieldText.matches("")) // if field is empty
            result = true;
        return result;
    }

    //highlight any empty fields red
    public void highlightEmptyFields(EditText field) {
        String fieldText = field.getText().toString();

        if (fieldText.matches("")) { // if field is empty
            field.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else{
            field.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }
}