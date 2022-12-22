package com.example.secondsemesterfinalproject2ndtime;

import javafx.scene.Node;

public class Password  {
    public  String Password;

    public Password(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return Password + '\n' ;
    }


}
