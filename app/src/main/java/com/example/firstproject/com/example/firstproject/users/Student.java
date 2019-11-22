package com.example.firstproject.com.example.firstproject.users;

public class Student extends User{

    public Student(){}

    public void printStudent(){
        System.out.println(getFirstName() + " " + getLastName());
    }
}
