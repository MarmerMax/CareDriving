package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView toRegistration;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        loginButton = findViewById(R.id.loginButton);
        inputEmail = findViewById(R.id.loginInputEmail);
        inputPassword = findViewById(R.id.loginInputPassword);
        toRegistration = findViewById(R.id.toRegistration);

        loginButton.setOnClickListener(this);
        toRegistration.setOnClickListener(this);

//        Toast.makeText(Login.this,
//                "Login activity", Toast.LENGTH_LONG).show();

    }



    @Override
    public void onClick(View view) {
        if (view == loginButton) {
            loginUser();
//            Toast.makeText(Login.this,
//                    "Login button", Toast.LENGTH_LONG).show();
        }

        if (view == toRegistration) {
            changeActivityToRegistration();
//            Toast.makeText(Login.this,
//                    "change to registration", Toast.LENGTH_LONG).show();
        }
    }

    private void changeActivityToRegistration(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    private void loginUser() {

    }
}
