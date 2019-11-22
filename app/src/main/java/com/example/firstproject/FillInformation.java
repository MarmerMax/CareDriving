package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.firstproject.com.example.firstproject.users.Student;
import com.example.firstproject.com.example.firstproject.users.Teacher;
import com.example.firstproject.com.example.firstproject.users.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FillInformation extends AppCompatActivity implements View.OnClickListener {

    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private EditText city;
    private Button saveInfo;

    private RadioGroup radioUserGroup;
    private RadioButton radioUserButton;

    private User user;
    private String chosenUser = "students"; //when save the user

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_information);

        firstName = findViewById(R.id.fillFirstName);
        lastName = findViewById(R.id.fillLastName);
        age = findViewById(R.id.fillAge);
        city = findViewById(R.id.fillCity);
        saveInfo = findViewById(R.id.buttonSaveInfo);

        radioUserGroup = findViewById(R.id.radioUser);

        myRef = FirebaseDatabase.getInstance().getReference();
        saveInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == saveInfo){
            saveInfoInFirebase();
        }
    }

    private void saveInfoInFirebase() {

        int selectedId = radioUserGroup.getCheckedRadioButtonId();
        radioUserButton = findViewById(selectedId);

        if(radioUserButton.getText().toString().toLowerCase().equals(chosenUser.substring(0, chosenUser.length() - 1))){
            user = new Student();
        } else {
            user = new Teacher();
            chosenUser = "teachers";
        }

        user.setFirstName(firstName.getText().toString().trim());
        user.setLastName(lastName.getText().toString().trim());
        user.setAge(age.getText().toString().trim());
        user.setCity(city.getText().toString().trim());

//        myRef.child(chosenUser).push().setValue(user);
        myRef.child(chosenUser).push().setValue(user);
    }
}
