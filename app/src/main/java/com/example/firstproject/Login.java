package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        firebaseAuth = FirebaseAuth.getInstance();



        progressDialog = new ProgressDialog(this);
        loginButton = findViewById(R.id.loginButton);
        inputEmail = findViewById(R.id.loginInputEmail);
        inputPassword = findViewById(R.id.loginInputPassword);
        toRegistration = findViewById(R.id.toRegistration);

        loginButton.setOnClickListener(this);
        toRegistration.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if (view == loginButton) {
            loginUser();
        }

        if (view == toRegistration) {
            changeActivityToRegistration();
        }
    }

    private void changeActivityToRegistration(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    private void loginUser() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if(email.length() == 0){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.length() == 0){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Login...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    }
                });
    }
}
