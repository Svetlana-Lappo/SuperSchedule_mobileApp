package com.telran.sheduler.tests.models;

public class User {
    private  String email;
    private  String password;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password){
        this.password = password;
        return this;
    }

    public User withEmail(String email){
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
