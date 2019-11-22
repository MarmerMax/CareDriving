package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyPage extends AppCompatActivity implements View.OnClickListener {

    private TextView firstName;
    private TextView lastName;
    private TextView age;
    private TextView city;
    private TextView email;
    private Button logoutButton;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        firstName = findViewById(R.id.textViewFirstName);
        lastName = findViewById(R.id.textViewLastName);
        age = findViewById(R.id.textViewAge);
        city = findViewById(R.id.textViewCity);
        email = findViewById(R.id.textViewEmail);
        logoutButton = findViewById(R.id.buttonLogout);

        email.setText(user.getEmail());


        firstName.setText(user.getUid());//uid


        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == logoutButton){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, Login.class));
        }
    }
}
