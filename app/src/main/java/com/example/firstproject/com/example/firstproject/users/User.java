package com.example.firstproject.com.example.firstproject.users;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class User {

    private String firstName;
    private String lastName;
//    private String email;
    private String city;
    private String age;


//    public abstract void registration();
//    public abstract void login();
//
//    public abstract void setLesson(Date date, String time, double duration);
//    public abstract void removeLesson(String id);

    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String secondName){this.lastName = secondName;}
//    public void setEmail(String email){this.email = email;}
    public void setCity(String city){this.city = city;}
    public void setAge(String age){this.age = age;}

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getAge(){return age;}
    public String getCity(){return city;}


}
