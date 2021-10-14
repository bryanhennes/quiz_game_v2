package com.bryan.myapplication;

public class User {
    private String username;
    private String password;

    User(String username1, String password1){
        username = username1;
        password = password1;
    }


    public void setUsername(String username1){
        username = username1;
    }

    public void setPassword(String password1){
        password = password1;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
